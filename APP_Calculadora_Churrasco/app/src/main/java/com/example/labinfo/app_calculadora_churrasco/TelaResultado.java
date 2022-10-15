package com.example.labinfo.app_calculadora_churrasco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaResultado extends AppCompatActivity {

    TextView tv_carne, tv_refrigerante, tv_agua, tv_vinho, tv_cerveja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resultado);

        tv_carne = (TextView)findViewById(R.id.tv_carne);
        tv_refrigerante = (TextView)findViewById(R.id.tv_refrigerante);
        tv_agua = (TextView)findViewById(R.id.tv_agua);
        tv_vinho = (TextView)findViewById(R.id.tv_vinho);
        tv_cerveja = (TextView)findViewById(R.id.tv_cerveja);

        tv_carne.setText("Carne (gramas): " + TelaPrincipal.total_carne);
        tv_vinho.setText("Vinho (litros): "+TelaPrincipal.total_vinho);
        tv_cerveja.setText("Cerveja (latas): "+TelaPrincipal.latas_cerveja);
        tv_refrigerante.setText("Refrigerante (litros): "+TelaPrincipal.total_refrigerante);
        tv_agua.setText("Água (litros): "+TelaPrincipal.total_agua);
    }

    public void voltar_clique(View v){
        finish();
    }

}
