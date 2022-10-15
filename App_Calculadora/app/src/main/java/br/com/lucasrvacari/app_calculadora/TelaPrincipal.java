package br.com.lucasrvacari.app_calculadora;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaPrincipal extends AppCompatActivity {

    //declarar os objetos
    TextView tv_resultado;
    EditText edit_n1, edit_n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        //mapeando objetos
        tv_resultado = (TextView)findViewById(R.id.tv_resultado);
        edit_n1 = (EditText)findViewById(R.id.edit_n1);
        edit_n2 = (EditText)findViewById(R.id.edit_n2);
    }

    //metodo do somar
    public void somar_clique(View v){

        //pegar os dados digitados
        String str_n1 = edit_n1.getText().toString();
        String str_n2 = edit_n2.getText().toString();

        //conversao de string para double
        double n1 = Double.parseDouble(str_n1);
        double n2 = Double.parseDouble(str_n2);

        //soma
        double soma = n1 + n2;

        //mostrar o result (converte de double para string)
        tv_resultado.setText(String.valueOf(soma));

        //mostra no toast
        //Toast.makeText(this, "Resultado: "+soma, Toast.LENGTH_LONG).show();

        //mostrar no alert
        AlertDialog.Builder alerta = new  AlertDialog.Builder(this);
        alerta.setTitle("Resultado:");
        alerta.setMessage("Da soma: "+soma);
        alerta.setNeutralButton("Fechar", null);
        alerta.show();
    }

    //botao limpar
    public void limpar_clique(View v){
        edit_n1.setText("");
        edit_n2.setText("");
        tv_resultado.setText("Aguardando...");
    }

    //subtracao
    public void sub_clique(View v){

        //pegar os dados digitados
        String str_n1 = edit_n1.getText().toString();
        String str_n2 = edit_n2.getText().toString();

        //conversao de string para double
        double n1 = Double.parseDouble(str_n1);
        double n2 = Double.parseDouble(str_n2);

        //subtracao
        double sub = n1 - n2;

        //mostrar o result (converte de double para string)
        tv_resultado.setText(String.valueOf(sub));

        //mostra no toast
        //Toast.makeText(this, "Resultado: "+sub, Toast.LENGTH_LONG).show();

        //mostrar no alert
        AlertDialog.Builder alerta = new  AlertDialog.Builder(this);
        alerta.setTitle("Resultado:");
        alerta.setMessage("Da subtração: "+sub);
        alerta.setNeutralButton("Fechar", null);
        alerta.show();
    }

    public void div_clique(View v){
        //pegar os dados digitados
        String str_n1 = edit_n1.getText().toString();
        String str_n2 = edit_n2.getText().toString();

        //conversao de string para double
        double n1 = Double.parseDouble(str_n1);
        double n2 = Double.parseDouble(str_n2);

        //Divisao
        double div = n1 / n2;

        //mostrar o result (converte de double para string)
        tv_resultado.setText(String.valueOf(div));

        //mostra no toast
        //Toast.makeText(this, "Resultado: "+div, Toast.LENGTH_LONG).show();

        //mostrar no alert
        AlertDialog.Builder alerta = new  AlertDialog.Builder(this);
        alerta.setTitle("Resultado:");
        alerta.setMessage("Da divisão: "+div);
        alerta.setNeutralButton("Fechar", null);
        alerta.show();
    }

    public void mult_clique(View v){
        //pegar os dados digitados
        String str_n1 = edit_n1.getText().toString();
        String str_n2 = edit_n2.getText().toString();

        //conversao de string para double
        double n1 = Double.parseDouble(str_n1);
        double n2 = Double.parseDouble(str_n2);

        //soma
        double mult = n1 * n2;

        //mostrar o result (converte de double para string)
        tv_resultado.setText(String.valueOf(mult));

        //mostra no toast
        //Toast.makeText(this, "Resultado: "+mult, Toast.LENGTH_LONG).show();

        //mostrar no alert
        AlertDialog.Builder alerta = new  AlertDialog.Builder(this);
        alerta.setTitle("Resultado:");
        alerta.setMessage("Da multiplicação: "+mult);
        alerta.setNeutralButton("Fechar", null);
        alerta.show();
    }
}
