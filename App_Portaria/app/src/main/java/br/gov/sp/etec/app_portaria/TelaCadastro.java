package br.gov.sp.etec.app_portaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarContext;

public class TelaCadastro extends AppCompatActivity {

    EditText edit_nome, edit_rg, edit_cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        edit_nome = (EditText)findViewById(R.id.edit_nome);
        edit_rg = (EditText)findViewById(R.id.edit_rg);
        edit_cidade = (EditText)findViewById(R.id.edit_cidade);

        //Conecta no banco
        SugarContext.init(this);
    }

    public void cadastrar_clique(View v){
        String nome = edit_nome.getText().toString();
        String rg = edit_rg.getText().toString();
        String cidade = edit_cidade.getText().toString();

        //Cadastro
        new Visitante(nome, rg, cidade).save();
        //Mostrar mensagem
        Toast.makeText(this, "Cadastrado", Toast.LENGTH_SHORT).show();
        //Volta
        finish();
    }
}
