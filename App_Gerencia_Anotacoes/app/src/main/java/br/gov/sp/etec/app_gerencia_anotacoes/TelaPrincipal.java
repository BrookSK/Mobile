package br.gov.sp.etec.app_gerencia_anotacoes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }

    public void gravar_clique(View v){
        startActivity(new Intent(this, TelaGravar.class));
    }

    public void recuperar_clique(View v){
        startActivity(new Intent(this, TelaListar.class));
    }
}
