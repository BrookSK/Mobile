package com.example.labinfo.app_fragment;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }

    public void pessoal_clique(View v){
        FragmentTransaction fragmento = getFragmentManager().beginTransaction();
        FragmentPessoal pessoal = new FragmentPessoal();
        fragmento.replace(R.id.frame, pessoal);
        fragmento.commit();
    }

    public void bancario_clique(View v){
        FragmentTransaction fragmento = getFragmentManager().beginTransaction();
        FragmentBancario bancario = new FragmentBancario();
        fragmento.replace(R.id.frame, bancario);
        fragmento.commit();
    }
}
