package br.com.lucasrvacari.app_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TelaResultado extends AppCompatActivity {

    TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_resultado);

        tv_resultado = (TextView)findViewById(R.id.tv_resultado);

        String mensagem = "Acertos: "+Pontuacao.ponto;

        tv_resultado.setText(mensagem);
    }

    public void reiniciar_clique(View v){
        Pontuacao.ponto = 0;
        startActivity(new Intent(this, TelaPrincipal.class));
    }

    //Impedir de voltar
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Quer roubar né kkk", Toast.LENGTH_SHORT).show();
    }
}
