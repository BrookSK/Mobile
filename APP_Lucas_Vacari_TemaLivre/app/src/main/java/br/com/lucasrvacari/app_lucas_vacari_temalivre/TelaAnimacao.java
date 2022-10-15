package br.com.lucasrvacari.app_lucas_vacari_temalivre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TelaAnimacao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_animacao);

        getSupportActionBar().setTitle("Rick And Morty");
    }
}
