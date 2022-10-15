package br.com.lucasrvacari.app_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Tela1Pergunta extends AppCompatActivity {

    RadioButton rdb_correta, rdb_errada1, rdb_errada2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1_pergunta);

        rdb_correta = (RadioButton)findViewById(R.id.rdb_correta);
        rdb_errada1 = (RadioButton)findViewById(R.id.rdb_errada1);
        rdb_errada2 = (RadioButton)findViewById(R.id.rdb_errada2);
    }

    public void proxima_clique(View v){
        if (!rdb_errada1.isChecked() && !rdb_errada2.isChecked() && !rdb_correta.isChecked()){
            Toast.makeText(this, "Escolha uma opção", Toast.LENGTH_SHORT).show();
        }else {
            if (rdb_correta.isChecked()) {
                Pontuacao.ponto++;
                Toast.makeText(this, "VOCÊ ACERTOU!!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "ERRROU :(", Toast.LENGTH_SHORT).show();
            }
            //Abre a segunda pergunta
            startActivity(new Intent(this, Tela2Pergunta.class));
        }
    }
}
