package br.gov.sp.etec.app_login_phila;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class TelaListar extends AppCompatActivity {

    ListView lst_usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar);

        lst_usuarios = (ListView)findViewById(R.id.lst_usuarios);

        //Conecta
        SugarContext.init(this);

        //Lista
        List<Usuario>usuarios = Usuario.listAll(Usuario.class);

        //Adapto
        ArrayAdapter<Usuario>adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, usuarios);

        //Mostra no listview
        lst_usuarios.setAdapter(adaptador);
    }
}
