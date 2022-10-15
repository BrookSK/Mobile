package br.gov.sp.etec.app_agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orm.SugarContext;

import java.util.List;

public class TelaListar extends AppCompatActivity {

    ListView lst_contatos;

    public static Contato contato_escolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar);

        lst_contatos = (ListView)findViewById(R.id.lst_contatos);
        getSupportActionBar().setTitle("Lista de usuário");


        SugarContext.init(this);
        listar();

        List<Contato> contatos = Contato.listAll(Contato.class);

        ArrayAdapter<Contato> adaptador = new ArrayAdapter<>(this,R.layout.item, R.id.tv_contato, contatos);

        lst_contatos.setAdapter(adaptador);

        lst_contatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contato_escolhido = (Contato)lst_contatos.getItemAtPosition(position);
                startActivity(new Intent(getApplication(), TelaAlterarExcluir.class));
            }
        });
    }


    private void listar(){
        List<Contato> contatos = Contato.listAll(Contato.class);

        ArrayAdapter<Contato> adaptador = new ArrayAdapter<>(this,R.layout.item, R.id.tv_contato, contatos);

        lst_contatos.setAdapter(adaptador);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listar();
    }
}
