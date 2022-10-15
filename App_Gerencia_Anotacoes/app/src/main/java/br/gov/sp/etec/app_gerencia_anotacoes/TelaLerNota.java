package br.gov.sp.etec.app_gerencia_anotacoes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.orm.SugarContext;

public class TelaLerNota extends AppCompatActivity {

    EditText edt_nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ler_nota);

        edt_nota = (EditText)findViewById(R.id.edt_nota);
        SugarContext.init(this);
        //Mostra nota escolhida
        edt_nota.setText(TelaListar.nota_selecionada.getNota());
    }
    public void gravar_clique(View v){
        String nota = edt_nota.getText().toString();
        //Atualiza
        TelaListar.nota_selecionada.setNota(nota);
        //Salva
        TelaListar.nota_selecionada.save();
        startActivity(new Intent(this, TelaPrincipal.class));
    }
    public void excluir_clique(View v){
        TelaListar.nota_selecionada.delete();
        startActivity(new Intent(this, TelaPrincipal.class));
    }
    public void voltar_clique(View v){
        startActivity(new Intent(this, TelaPrincipal.class));
    }
}
