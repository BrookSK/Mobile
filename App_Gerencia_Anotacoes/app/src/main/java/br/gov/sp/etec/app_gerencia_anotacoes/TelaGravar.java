package br.gov.sp.etec.app_gerencia_anotacoes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.orm.SugarContext;

public class TelaGravar extends AppCompatActivity {
    EditText edt_titulo, edt_nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_gravar);

        edt_titulo = (EditText)findViewById(R.id.edt_titulo);
        edt_nota = (EditText)findViewById(R.id.edt_nota);
        SugarContext.init(this);
    }

    public void gravar_clique(View v){
        String titulo = edt_titulo.getText().toString();
        String nota = edt_nota.getText().toString();
        new Nota(titulo, nota).save();
        Toast.makeText(this, "INCLUÍDO COM SUCESSO", Toast.LENGTH_SHORT).show();
        finish();
    }
}
