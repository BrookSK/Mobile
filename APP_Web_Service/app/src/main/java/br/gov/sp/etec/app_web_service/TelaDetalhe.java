package br.gov.sp.etec.app_web_service;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TelaDetalhe extends AppCompatActivity {

    TextView tv_sinopse;
    ImageView img_foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_detalhe);

        tv_sinopse = (TextView)findViewById(R.id.tv_sinopse);
        img_foto = (ImageView)findViewById(R.id.img_foto);

        //Mostro a sinopse
        tv_sinopse.setText(TelaPrincipal.filme_escolhido.getSinopse());

        //pegar a url
        String url = TelaPrincipal.filme_escolhido.getFoto();

        //Mostro a foto
        Picasso.with(this).load(url).into(img_foto);
    }
}
