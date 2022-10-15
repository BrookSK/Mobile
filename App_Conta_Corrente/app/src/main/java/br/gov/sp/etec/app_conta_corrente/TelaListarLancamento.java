package br.gov.sp.etec.app_conta_corrente;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

public class TelaListarLancamento extends AppCompatActivity {

    ListView lst_lancamento;

    //GUARDA EM MEMÓRIO A CONTA ESCOLHIDA
    public static Conta conta_escolhida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar_lancamento);

        lst_lancamento = (ListView)findViewById(R.id.lst_lancamento);

        SugarContext.init(this);
        final List<Conta> contas = Conta.listAll(Conta.class);

        ArrayAdapter<Conta> adaptador = new ArrayAdapter<Conta>(this, android.R.layout.simple_list_item_1, contas);

        lst_lancamento.setAdapter(adaptador);

        //clique na listagem
        lst_lancamento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                conta_escolhida = (Conta)lst_lancamento.getItemAtPosition(position);
                startActivity(new Intent(getApplicationContext(),TelaAlterarExcluir.class));
            }
        });
    }
}
