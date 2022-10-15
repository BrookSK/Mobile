package br.com.lucasrvacari.app_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;


public class Tela2Pergunta extends AppCompatActivity {

    RadioButton rdb_correta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2_pergunta);

        rdb_correta = (RadioButton)findViewById(R.id.rdb_correta);
    }

    public void proxima_clique(View v){
        if (rdb_correta.isChecked()){
            Pontuacao.ponto++;
            Toast.makeText(this, "VOCÊ ACERTOU!!!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "ERRROU :(", Toast.LENGTH_SHORT).show();
        }
        //Abre a segunda pergunta
        startActivity(new Intent(this, Tela3Pergunta.class));
    }

    //Impedir de voltar
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Quer roubar né kkk", Toast.LENGTH_SHORT).show();
    }
}
