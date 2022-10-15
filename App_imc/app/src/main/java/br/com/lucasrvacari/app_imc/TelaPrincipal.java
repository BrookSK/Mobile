package br.com.lucasrvacari.app_imc;

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
    public void calcular_clique(View v){

        //pegar os dados digitados
        String str_n1 = edit_n1.getText().toString();
        String str_n2 = edit_n2.getText().toString();

        //conversao de string para double
        double n1 = Double.parseDouble(str_n1);
        double n2 = Double.parseDouble(str_n2);

        //soma
        double imc = n1 / (n2*n2);

        if (imc <= 17){
            //mostrar o result (converte de double para string)
            tv_resultado.setText(String.valueOf("Voçê está muito a baixo do peso"));
            Toast.makeText(this, "Resultado: "+imc, Toast.LENGTH_LONG).show();
        } else{
        if(imc == 17.01 || imc < 18.49){
            tv_resultado.setText(String.valueOf("Voçê está abaixo do peso"));
            Toast.makeText(this, "Resultado: "+imc, Toast.LENGTH_LONG).show();
        } else{
        if(imc == 18.5 || imc <24.99){
            tv_resultado.setText(String.valueOf("Voçê está no peso normal"));
            Toast.makeText(this, "Resultado: "+imc, Toast.LENGTH_LONG).show();
        } else {
            if (imc == 25 || imc < 29.99) {
                tv_resultado.setText(String.valueOf("Voçê está acima do peso"));
                Toast.makeText(this, "Resultado: "+imc, Toast.LENGTH_LONG).show();
            } else {
                if (imc == 30 || imc < 34.99) {
                    tv_resultado.setText(String.valueOf("Voçê está com obesidade 1"));
                    Toast.makeText(this, "Resultado: "+imc, Toast.LENGTH_LONG).show();
                } else {
                    if (imc == 35 || imc < 39.99) {
                        tv_resultado.setText(String.valueOf("Voçê está com obesidade 2"));
                        Toast.makeText(this, "Resultado: "+imc, Toast.LENGTH_LONG).show();
                    } else {
                        if (imc >= 40) {
                            tv_resultado.setText(String.valueOf("Voçê está com obesidade 3"));
                            Toast.makeText(this, "Resultado: "+imc, Toast.LENGTH_LONG).show();
                        }

                        //mostrar o result (converte de double para string)
                        //tv_resultado.setText(String.valueOf(imc));

                        //mostra no toast
                        //Toast.makeText(this, "Resultado: "+imc, Toast.LENGTH_LONG).show();

                        //mostrar no alert
                        //AlertDialog.Builder alerta = new  AlertDialog.Builder(this);
                        //alerta.setTitle("Resultado:");
                        //alerta.setMessage("Da soma: "+imc);
                        //alerta.setNeutralButton("Fechar", null);
                        //alerta.show();
                    }




}
            }
        }
        }
        }
    }
}