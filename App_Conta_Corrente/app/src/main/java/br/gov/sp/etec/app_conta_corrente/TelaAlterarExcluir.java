package br.gov.sp.etec.app_conta_corrente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.orm.SugarContext;

public class TelaAlterarExcluir extends AppCompatActivity {

    RadioButton rdb_debito, rdb_credito;
    EditText edit_descricao, edit_valor, edit_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_alterar_excluir);

        rdb_credito = (RadioButton)findViewById(R.id.rdb_credito);
        edit_descricao = (EditText)findViewById(R.id.edit_descricao);
        edit_valor = (EditText)findViewById(R.id.edit_valor);
        edit_data = (EditText)findViewById(R.id.edit_data);
        rdb_debito =  (RadioButton)findViewById(R.id.rdb_debito);
        rdb_credito =  (RadioButton)findViewById(R.id.rdb_credito);

        //Puxo os dados da conta escolhida
        if (TelaListarLancamento.conta_escolhida.getTipo().equals("C")){
            rdb_credito.setChecked(true);
        }else {
            rdb_debito.setChecked(true);
        }

        edit_descricao.setText(TelaListarLancamento.conta_escolhida.getDescricao());
        edit_valor.setText(String.valueOf(TelaListarLancamento.conta_escolhida.getValor()));
        edit_data.setText(TelaListarLancamento.conta_escolhida.getData());

        SugarContext.init(this);
    }

    public void alterar_clique(View v)
    {
        String tipo = "";
        if (rdb_credito.isChecked()){
            tipo = "C";
        }else{
            tipo = "D";
        }
        String descricao = edit_descricao.getText().toString();
        double valor = Double.parseDouble(edit_valor.getText().toString());
        String data = edit_data.getText().toString();
        TelaListarLancamento.conta_escolhida.setData(data);
        TelaListarLancamento.conta_escolhida.setDescricao(descricao);
        TelaListarLancamento.conta_escolhida.setTipo(tipo);
        TelaListarLancamento.conta_escolhida.setValor(valor);
        //Update
        TelaListarLancamento.conta_escolhida.save();
        voltar();
    }
    public void excluir_clique(View v)
    {
        //Delete
        TelaListarLancamento.conta_escolhida.delete();
        voltar();
    }
    private void voltar()
    {
        Intent tela = new Intent(this, TelaPrincipal.class);
        startActivity(tela);
    }
}
