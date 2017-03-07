package com.example.salva.jsonapp.activities.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by salva on 27/02/2017.
 */

public class Student {

    private static final String NAME_KEY = "nome";
    private static final String EMAIL_KEY = "email";
    private static final String GITHUB_KEY = "github";
    /*private static final String COURSE_KEY = "corso";*/
    private static final String STUDENT_IMAGE = "avatar";

    String name, email, github;
    private String imageUrl;

    /*Corso corso;*/

    /*public Corso getCorso() {
        return this.corso;
    }*/

    public Student(JSONObject jsonStudent) {
        try {
            name = jsonStudent.getString(NAME_KEY);
            email = jsonStudent.getString(EMAIL_KEY);
            imageUrl = jsonStudent.optString(STUDENT_IMAGE);
            github = buildGithubUrl(jsonStudent.optString(GITHUB_KEY,""));
            /*corso = new Corso(jsonStudent.getJSONObject(COURSE_KEY));*/
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }
    private String buildGithubUrl(String username){
        username = username.replace("@","");
        return "https://github.com/" + username;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
