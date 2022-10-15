package com.example.labinfo.app_horario_escolar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class TelaPrincila extends AppCompatActivity {

    Spinner spn_dia;
    ListView lst_aulas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_princila);

        spn_dia = (Spinner)findViewById(R.id.spn_dia);
        lst_aulas = (ListView)findViewById(R.id.lst_aulas);

        spn_dia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String dia = spn_dia.getSelectedItem().toString();
                filtrar(dia);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void mostrar_professor(String aula){
        if(aula.equals("1º BLOCO - DS")){
            Toast.makeText(this, "Professor ALEXEI", Toast.LENGTH_SHORT).show();
        }

        if(aula.equals("2º BLOCO - DS")){
            Toast.makeText(this, "Professor BRUNO", Toast.LENGTH_SHORT).show();
        }
    }

    private void filtrar(String dia){
        ArrayAdapter<CharSequence> adaptador = null;
        if(dia.equals("Segunda-Feira")){
            adaptador = ArrayAdapter.createFromResource(this, R.array.segunda,android.R.layout.simple_list_item_1);
        }

        if(dia.equals("Terça-Feira")){
            adaptador = ArrayAdapter.createFromResource(this, R.array.terca,android.R.layout.simple_list_item_1);
        }

        if(dia.equals("Quarta-Feira")){
            adaptador = ArrayAdapter.createFromResource(this, R.array.quarta,android.R.layout.simple_list_item_1);
        }

        if(dia.equals("Quinta-Feira")){
            adaptador = ArrayAdapter.createFromResource(this, R.array.quinta,android.R.layout.simple_list_item_1);
        }

        if(dia.equals("Sexta-Feira")){
            adaptador = ArrayAdapter.createFromResource(this, R.array.sexta,android.R.layout.simple_list_item_1);
        }
        lst_aulas.setAdapter(adaptador);
    }
}
