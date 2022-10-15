package br.gov.sp.etec.app_agenda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarContext;


public class TelaCadastrar extends AppCompatActivity {

    EditText edt_nome, edt_telefone, edt_cidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar);

        edt_nome = (EditText)findViewById(R.id.edt_nome);
        edt_telefone = (EditText)findViewById(R.id.edt_telefone);
        edt_cidade = (EditText)findViewById(R.id.edt_cidade);
        //Conecta
        SugarContext.init(this);

    }

    public void cadastrar_clique(View v){
        //Pego os dados digitados
        String nome = edt_nome.getText().toString();
        String telefone = edt_telefone.getText().toString();
        String cidade = edt_cidade.getText().toString();
        //Cadastro
        new Contato(nome, telefone,cidade).save();
        //Mostra mensagem e volta para a tela principal
        Toast.makeText(this, "Cadastrado!", Toast.LENGTH_SHORT).show();
        finish();
    }


}
