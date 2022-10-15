package br.gov.sp.etec.app_portaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.orm.SugarContext;

import java.util.List;

public class TelaPesquisar extends AppCompatActivity {

    EditText edit_nome;
    ListView lst_visitantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pesquisar);

        edit_nome = (EditText)findViewById(R.id.edit_nome);
        lst_visitantes = (ListView)findViewById(R.id.lst_visitantes);
        //Conecta no banco
        SugarContext.init(this);
    }

    public void pesquisar_clique(View v){
        //Pego mo nome do visitante
        String nome = edit_nome.getText().toString();
        //Pesquisar
        List<Visitante> visitantes = Visitante.find(Visitante.class, "nome LIKE ?", nome + "%");
        ArrayAdapter<Visitante>adaptador = new ArrayAdapter<Visitante>(this,R.layout.item, R.id.tv_visitante, visitantes);
        lst_visitantes.setAdapter(adaptador);
    }
}
