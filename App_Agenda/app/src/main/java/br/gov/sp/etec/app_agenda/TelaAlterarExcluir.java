package br.gov.sp.etec.app_agenda;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.orm.SugarContext;

public class TelaAlterarExcluir extends AppCompatActivity {
    EditText edt_nome, edt_telefone, edt_cidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_alterar_excluir);
        edt_nome = (EditText)findViewById(R.id.edt_nome);
        edt_cidade = (EditText)findViewById(R.id.edt_cidade);
        edt_telefone = (EditText)findViewById(R.id.edt_telefone);
        SugarContext.init(this);

        edt_nome.setText(TelaListar.contato_escolhido.getNome());
        edt_telefone.setText(TelaListar.contato_escolhido.getTelefone());
        edt_cidade.setText(TelaListar.contato_escolhido.getCidade());
    }


    public  void alterar_clique(View v){

     String nome = edt_nome.getText().toString();
        String telefone = edt_telefone.getText().toString();
        String cidade = edt_cidade.getText().toString();

        TelaListar.contato_escolhido.setNome(nome);
        TelaListar.contato_escolhido.setTelefone(telefone);
        TelaListar.contato_escolhido.setCidade(cidade);

        TelaListar.contato_escolhido.save();
        finish();

    }

    public void excluir_clique(View v){
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Atenção!!");
        alerta.setMessage("Voce deseja excluir?" + "\n" + TelaListar.contato_escolhido.getNome() + "?");
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                TelaListar.contato_escolhido.delete();
                finish();
            }
        });
        alerta.setNeutralButton("Nao", null);
        alerta.show();
      

    }
}
