package br.gov.sp.etec.app_conta_corrente;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.orm.SugarContext;
import com.orm.SugarDb;

import org.w3c.dom.Text;

import java.sql.SQLClientInfoException;

public class TelaPrincipal extends AppCompatActivity {

    TextView tv_credito, tv_debito, tv_saldo;

    double credito, debito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        tv_credito = (TextView)findViewById(R.id.tv_credito);
        tv_debito = (TextView)findViewById(R.id.tv_debito);
        tv_saldo = (TextView)findViewById(R.id.tv_saldo);

        //conectando o bd
        SugarContext.init(this);
    }

    public void incluir_clique(View v){
        Intent tela = new Intent(this, TelaLancamento.class);
        startActivity(tela);
    }

    public void listar_clique(View v){
        Intent tela = new Intent(this, TelaListarLancamento.class);
        startActivity(tela);
    }

    public void totalizarCredito(){
        SugarDb banco = new SugarDb(this);
        SQLiteDatabase database = banco.getDB();
        SQLiteStatement query = database.compileStatement("SELECT SUM(valor) FROM Conta WHERE tipo= 'C'");
        credito = query.simpleQueryForLong();
        tv_credito.setText("Total em crédito:\nR$" + credito);
    }

    public void totalizarDebito(){
        SugarDb banco = new SugarDb(this);
        SQLiteDatabase database = banco.getDB();
        SQLiteStatement query = database.compileStatement("SELECT SUM(valor) FROM Conta WHERE tipo= 'D'");
        debito = query.simpleQueryForLong();
        tv_debito.setText("Total em débito:\nR$"+debito);
    }

    private void getSaldo(){
        double saldo = credito - debito;
        tv_saldo.setText("Saldo atual:\nR$ "+saldo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        totalizarCredito();
        totalizarDebito();
        getSaldo();
    }
}
