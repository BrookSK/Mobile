package br.gov.sp.etec.app_portaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SugarContext;

import java.util.List;

public class TelaPrincipal extends AppCompatActivity {

    EditText edit_rg;
    TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        edit_rg = (EditText)findViewById(R.id.edit_rg);
        tv_resultado = (TextView)findViewById(R.id.tv_resultado);
    }

    //Chama a tela Cadastro
    public void cadastrar_clique(View v){
        startActivity(new Intent(this, TelaCadastro.class));
    }

    //Chama a tela Pesquisar
    public void pesquisar_clique(View v){
        startActivity(new Intent(this, TelaPesquisar.class));
    }

    public void buscar_clique(View v){
        //Conecta
        SugarContext.init(this);
        //Pega o rg
        String rg = edit_rg.getText().toString();
        //Filtros
        List<Visitante>visitantes = Visitante.find(Visitante.class, "rg = ?", rg);
        //Vejo se encontrou
        if(!visitantes.isEmpty()){
            String nome = visitantes.get(0).getNome();
            String cidade = visitantes.get(0).getCidade();
            tv_resultado.setText(nome + "\n" + cidade);
        }else {
            Toast.makeText(this, "NÃO ENCONTRADO!", Toast.LENGTH_SHORT).show();
        }
    }
}
