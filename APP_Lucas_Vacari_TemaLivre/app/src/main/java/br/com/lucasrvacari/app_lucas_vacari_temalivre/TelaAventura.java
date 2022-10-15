package br.com.lucasrvacari.app_lucas_vacari_temalivre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaAventura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_aventura);

        getSupportActionBar().setTitle("Amor e Monstros");
    }
}
