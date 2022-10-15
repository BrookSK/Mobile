package br.gov.sp.etec.app_agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }

    public void cadastrar_clique(View v){
        startActivity(new Intent(this, TelaCadastrar.class));
    }
    public void listar_clique(View v){
        startActivity(new Intent(this, TelaListar.class));
    }

}
