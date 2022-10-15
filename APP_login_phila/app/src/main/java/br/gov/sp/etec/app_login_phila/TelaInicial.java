package br.gov.sp.etec.app_login_phila;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaInicial extends AppCompatActivity {

    TextView tv_bemvindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        tv_bemvindo = (TextView)findViewById(R.id.tv_bemvindo);

        tv_bemvindo.setText("Bem-vindo(a): "+Usuario.usuario_logado);
    }

    public void listar_clique(View v){
        startActivity(new Intent(this, TelaListar.class));
    }
}
