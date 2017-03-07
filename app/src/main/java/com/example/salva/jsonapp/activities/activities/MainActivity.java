package com.example.salva.jsonapp.activities.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.salva.jsonapp.R;
import com.example.salva.jsonapp.activities.adapter.StudentsAdapter;
import com.example.salva.jsonapp.activities.model.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 * Created by salva on 27/02/2017.
 */


public class MainActivity extends AppCompatActivity {
    RecyclerView studentsRv;
    LinearLayoutManager layoutManager;
    StudentsAdapter adapter;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentsRv = (RecyclerView) findViewById(R.id.students_rv);
        layoutManager = new LinearLayoutManager(this);
        adapter = new StudentsAdapter();
        studentsRv.setLayoutManager(layoutManager);
        studentsRv.setAdapter(adapter);
        fetchStudentsFromJSON();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void fetchStudentsFromJSON() {
        ArrayList<Student> students = new ArrayList<>();
        try {


            /*JSONObject studentsJsonObject = new JSONObject(readLocalJson());*/
            /*JSONArray studentsJsonArray = studentsJsonObject.getJSONArray("students");*/
            JSONArray studentsJsonArray = new JSONArray(readLocalJson());
            for (int i = 0; i < studentsJsonArray.length(); i++) {
                JSONObject jsonStudent = studentsJsonArray.getJSONObject(i);
                students.add(new Student(jsonStudent));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        // add dataset to adapter
        adapter.setDataSet(students);

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private String readLocalJson() {

        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try (InputStream is = getResources().openRawResource(R.raw.students)) {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer.toString();
    }
}