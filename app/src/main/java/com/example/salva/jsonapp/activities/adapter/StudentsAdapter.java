package com.example.salva.jsonapp.activities.adapter;

/**
 * Created by salva on 27/02/2017.
 */
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.salva.jsonapp.R;
import com.example.salva.jsonapp.activities.activities.ImageDownloaderTask;
import com.example.salva.jsonapp.activities.model.Student;

import java.util.ArrayList;

/**
 * Created by salva on 27/02/2017.
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {

    private ArrayList<Student> dataSet = new ArrayList<>();


    @Override
    public StudentsAdapter.StudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        StudentViewHolder holder = new StudentViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(StudentViewHolder holder, int position) {
        Student currentStudent = dataSet.get(position);
        holder.studentNameTv.setText(currentStudent.getName());
        holder.studentEmail.setText(currentStudent.getEmail());
        /*holder.studentCourseTv.setText(currentStudent.getCorso().getNome());
        holder.studentIdTv.setText(String.valueOf(currentStudent.getCorso().getId()));*/
        new ImageDownloaderTask(holder.studentImage).execute(currentStudent.getImageUrl());


    }

    public void setDataSet(ArrayList<Student> students) {
        dataSet = students;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }


     class StudentViewHolder extends RecyclerView.ViewHolder {
        public TextView studentNameTv;
        public TextView studentEmail;
        public ImageButton studenGithub;
        public TextView studentCourseTv;
        public TextView studentIdTv;
         public ImageView studentImage;

        public StudentViewHolder(View v) {
            super(v);
            studentNameTv = (TextView) v.findViewById(R.id.student_name);
            studentEmail = (TextView) v.findViewById(R.id.student_email);
            studenGithub = (ImageButton) v.findViewById(R.id.student_github);
            /*studentCourseTv = (TextView) v.findViewById(R.id.student_course);
            studentIdTv = (TextView) v.findViewById(R.id.student_id);*/
            studentImage = (ImageView)v.findViewById(R.id.student_image);

            studenGithub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent();
                    i.setAction(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(dataSet.get(getAdapterPosition()).getGithub()));
                    itemView.getContext().startActivity(i);


                }
            });
        }
    }
}
