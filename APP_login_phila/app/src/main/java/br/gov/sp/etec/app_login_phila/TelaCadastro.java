package br.gov.sp.etec.app_login_phila;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarContext;

public class TelaCadastro extends AppCompatActivity {

    EditText edit_nome, edit_senha, edit_confirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        edit_nome = (EditText)findViewById(R.id.edit_nome);
        edit_confirma = (EditText)findViewById(R.id.edit_confirma);
        edit_senha = (EditText)findViewById(R.id.edit_senha);

        //Conecta
        SugarContext.init(this);
    }

    public void cadastrar_clique(View v){
        //Obtendo o que o usuario digitou
        String nome = edit_nome.getText().toString();
        String senha = edit_senha.getText().toString();
        String confirma = edit_confirma.getText().toString();

        if (senha.equals(confirma)){
            //Insere o usuario no banco de dados
            new Usuario(nome, senha).save();

            //Mensagem que gravou
            Toast.makeText(this, "USUARO INCLUIDO", Toast.LENGTH_SHORT).show();

            //Volto para a tela de login
            finish();
        }else {
            Toast.makeText(this, "SENHAS NÃO CONFEREM", Toast.LENGTH_SHORT).show();
        }
    }
}
