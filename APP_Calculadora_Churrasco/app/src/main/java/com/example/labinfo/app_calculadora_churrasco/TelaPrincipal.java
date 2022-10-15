package com.example.labinfo.app_calculadora_churrasco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class TelaPrincipal extends AppCompatActivity {


    EditText edt_qtd_adulto, edt_qtd_crianca;
    CheckBox chk_carne, chk_refrigerante, chk_agua, chk_vinho, chk_cerveja;

    public static double total_carne, total_vinho, total_refrigerante, total_agua;
    public static int latas_cerveja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        edt_qtd_adulto = (EditText)findViewById(R.id.edt_qtd_adulto);
        edt_qtd_crianca = (EditText)findViewById(R.id.edt_qtd_crianca);

        chk_carne = (CheckBox)findViewById(R.id.chk_carne);
        chk_refrigerante = (CheckBox)findViewById(R.id.chk_refri);
        chk_agua = (CheckBox)findViewById(R.id.chk_agua);
        chk_vinho = (CheckBox)findViewById(R.id.chk_vinho);
        chk_cerveja = (CheckBox)findViewById(R.id.chk_cerv);
    }

    //clique do botao
    public void calcular_clique(View v){
        int qtd_adulto = 0;
        if (!edt_qtd_adulto.getText().toString().equals("")) {
            qtd_adulto = Integer.parseInt(edt_qtd_adulto.getText().toString());
        }

        int qtd_crianca = 0;
        if (!edt_qtd_crianca.getText().toString().equals("")) {
            qtd_crianca = Integer.parseInt(edt_qtd_crianca.getText().toString());
        }

        if (chk_carne.isChecked()){
            total_carne = (400 * qtd_adulto) + (200 * qtd_crianca);
        }else{
            total_carne = 0;
        }

        if (chk_refrigerante.isChecked()){
            total_refrigerante = (1 * qtd_adulto) + (0.5 * qtd_crianca);
        }else{
            total_refrigerante = 0;
        }

        if (chk_agua.isChecked()){
            total_agua = (0.6 * qtd_adulto) + (0.3 * qtd_crianca);
        }else{
            total_agua = 0;
        }

        if (chk_cerveja.isChecked()){
            latas_cerveja = qtd_adulto * 4;
        }else{
            latas_cerveja = 0;
        }

        if (chk_vinho.isChecked()){
            total_vinho = 0.5 * qtd_adulto;
        }else{
            total_vinho = 0;
        }
        startActivity(new Intent(this, TelaResultado.class));
    }

    //Após voltar, limpa tudo
    @Override
    protected void onResume() {
        super.onResume();
        edt_qtd_adulto.setText("");
        edt_qtd_crianca.setText("");
        chk_carne.setChecked(false);
        chk_refrigerante.setChecked(false);
        chk_agua.setChecked(false);
        chk_vinho.setChecked(false);
        chk_cerveja.setChecked(false);
    }
}
