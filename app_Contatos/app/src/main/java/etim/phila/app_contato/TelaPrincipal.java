package etim.phila.app_contato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TelaPrincipal extends AppCompatActivity {

    ListView lst_pessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        lst_pessoas = (ListView)findViewById(R.id.lst_pessoas);

        ArrayList<Pessoa> contatos = new ArrayList<>();

        contatos.add(new Pessoa("Carlos dos Santos",R.drawable.carlos, "9454-5455", "Mirassol", "Desenvolvedor"));
        contatos.add(new Pessoa("Fernanda Silva",R.drawable.fernanda, "7545-3525", "Rio Preto", "Secretária"));
        contatos.add(new Pessoa("Maria Ferreira", R.drawable.fernanda, "9875-2421", "Bálsamo", "Ferreiro"));
        contatos.add(new Pessoa("Pedro Souza", R.drawable.pedro, "9874-1425", "Monte Aprazível", "Modelo"));

        PessoaAdapter adapter = new PessoaAdapter(this, contatos);


        lst_pessoas.setAdapter(adapter);
    }
}
