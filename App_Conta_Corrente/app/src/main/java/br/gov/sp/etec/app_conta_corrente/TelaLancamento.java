package br.gov.sp.etec.app_conta_corrente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.orm.SugarContext;

public class TelaLancamento extends AppCompatActivity {

    RadioButton rdb_credito;
    EditText edit_descricao, edit_valor, edit_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_lancamento);

        rdb_credito = (RadioButton)findViewById(R.id.rdb_credito);
        edit_descricao = (EditText)findViewById(R.id.edit_descricao);
        edit_valor = (EditText)findViewById(R.id.edit_valor);
        edit_data = (EditText)findViewById(R.id.edit_data);

        SugarContext.init(this);
    }

    public void incluir_clique(View v){
        String tipo = "";
        if (rdb_credito.isChecked()){
            tipo = "C";
        }else {
            tipo = "D";
        }

        String descricao = edit_descricao.getText().toString();
        double valor = Double.parseDouble(edit_valor.getText().toString());
        String data = edit_data.getText().toString();

        new Conta(descricao, data, tipo, valor).save();
        finish();
    }
}
