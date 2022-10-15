package com.example.labinfo.app_lucass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Tela_comedia extends AppCompatActivity {

    ListView list_comedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_comedia);

        list_comedia=(ListView)findViewById(R.id.list_comedia);

        ArrayList<String>filmes=new ArrayList<>();

        filmes.add("SE BEBER NÃO CASE");

        ArrayList<String>adaptador=new ArrayList<String>(this, android.R.layout.simple_list_item_1, android.R.);

        list_comedia.setAdapter((ListAdapter) adaptador);


    }
}
