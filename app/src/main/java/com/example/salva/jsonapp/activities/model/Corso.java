package com.example.salva.jsonapp.activities.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by salva on 27/02/2017.
 */

public class Corso {

    private static final String NAME_KEY = "nome";
    private static final String ID_KEY = "id";

    String nome;
    int id;

    public Corso(JSONObject jsonStudent){
        try {
            nome = jsonStudent.getString(NAME_KEY);
            id = jsonStudent.getInt(ID_KEY);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
