package br.gov.sp.etec.app_gerencia_anotacoes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orm.SugarContext;

import java.util.List;

public class TelaListar extends AppCompatActivity {

    ListView lst_notas;
    public static Nota nota_selecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar);

        lst_notas = (ListView)findViewById(R.id.lst_notas);
        SugarContext.init(this);
        List<Nota> notas = Nota.listAll(Nota.class);
        ArrayAdapter<Nota> adaptador = new ArrayAdapter<Nota>(this,
                R.layout.item, R.id.tv_nota,notas);
        lst_notas.setAdapter(adaptador);
        //Clique na nota
        lst_notas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                nota_selecionada = (Nota) lst_notas.getItemAtPosition(position);
                startActivity(new Intent(getApplicationContext(), TelaLerNota.class));
            }
        });
    }
}
