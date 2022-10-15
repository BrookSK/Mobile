package br.gov.sp.etec.apptarefa_3ds;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.List;

public class TelaPrincipal extends AppCompatActivity {

    EditText editText;
    ListView lst_tarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        editText = (EditText)findViewById(R.id.edit_tarefa);
        lst_tarefas = (ListView)findViewById(R.id.lst_tarefa);

        //conecta no bd
        SugarContext.init(this);
        listar();

        //tratamento do clique
        lst_tarefas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //pego o obj
                Tarefa tarefa=(Tarefa)lst_tarefas.getItemAtPosition(position);
                //chama o excluir
                excluir(tarefa);
            }
        });
    }

    public void incluir_clique(View v){
        String nome_tarefa=editText.getText().toString();
        if (nome_tarefa.equals("")){
            Toast.makeText(this,"Digite o nome da tarefa!", Toast.LENGTH_SHORT).show();
        }else{
            //cadastra
            new Tarefa(nome_tarefa).save();

            editText.setText("");
            Toast.makeText(this,"Cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();

            //Lista
            List<Tarefa> tarefas=Tarefa.listAll(Tarefa.class);
            ArrayAdapter<Tarefa> adaptador=new ArrayAdapter<>(this, R.layout.item, R.id.tv_tarefa, tarefas);
            lst_tarefas.setAdapter(adaptador);
            listar();
        }
    }

    private  void listar(){
        List<Tarefa>tarefas=Tarefa.listAll(Tarefa.class);
        ArrayAdapter<Tarefa> adaptador = new ArrayAdapter<Tarefa>(this,R.layout.item,R.id.tv_tarefa,tarefas);
        lst_tarefas.setAdapter(adaptador);

    }

    private void excluir(final Tarefa tarefa){
        AlertDialog.Builder alerta=new AlertDialog.Builder(this);
        alerta.setTitle("Atenção!!!");
        alerta.setMessage("Deseja Excluir "+tarefa.getTarefa()+" ?");
        alerta.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tarefa.delete();
                listar();
            }
        });
        alerta.setNeutralButton("NÃO", null);
        alerta.show();
    }
}
