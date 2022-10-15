package com.example.labinfo.app_trabalho_listaplaneta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaPrincipal extends AppCompatActivity {

    //Declarando o listview
    ListView lst_planetas;

    //Atributo para guardar o planeta que o usuário clicou
    public static Planeta planeta_selecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        //Mapeando o listview da tela
        lst_planetas = (ListView)findViewById(R.id.lst_planetas);

        //Crio uma lista de planeta
        ArrayList<Planeta> planetas = new ArrayList<>();

        //Adiciono os objetos palnetas na lista
        planetas.add(new Planeta("Sol", R.drawable.sol, "Distância: 8 minutos na velocidade da luz."));
        planetas.add(new Planeta("Mercúrio", R.drawable.mercurio, "Temperatura: 166,85 graus"));
        planetas.add(new Planeta("Vênus", R.drawable.venus, "Temperatura: 461 graus"));
        planetas.add(new Planeta("Terra", R.drawable.terra, "Conhecido como Planeta Azul"));
        planetas.add(new Planeta("Marte", R.drawable.marte, "Temperatura média: -63 graus"));

        //Adaptando
        PlanetaAdapter adaptador = new PlanetaAdapter(
                getApplicationContext(),
                planetas
        );

        //Mostrando
        lst_planetas.setAdapter(adaptador);
    }

}
