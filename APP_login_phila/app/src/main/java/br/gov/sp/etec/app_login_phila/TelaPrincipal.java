package br.gov.sp.etec.app_login_phila;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarContext;
import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.List;

public class TelaPrincipal extends AppCompatActivity {

    EditText edit_usuario, edit_senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        edit_usuario = (EditText)findViewById(R.id.edit_usuario);
        edit_senha = (EditText)findViewById(R.id.edit_senha);
        //Conecta
        SugarContext.init(this);
    }

    public void cadastrar_clique(View v){
        startActivity(new Intent(this, TelaCadastro.class));
    }

    public void logar_clique(View v){
        //Dados que o usuario digitou
        String nome = edit_usuario.getText().toString();
        String senha = edit_senha.getText().toString();

        //Consulta
        List<Usuario> usuario = Select.from(Usuario.class)
                .where(Condition.prop("nome").eq(nome),Condition.prop("senha").eq(senha))
        .list();

        //Verifico se encontrou
        if (usuario.size()>0){
            //Guardo o nome do usuario
            Usuario.usuario_logado = nome;

            startActivity(new Intent(this, TelaInicial.class));
        }else {
            Toast.makeText(this, "Usuario ou senha invalidos", Toast.LENGTH_SHORT).show();
        }
    }
}
