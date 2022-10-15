package br.gov.sp.etec.app_previsao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaPrincipal extends AppCompatActivity {
    TextView tv_temperatura, tv_situacao, tv_umidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        tv_temperatura = (TextView)findViewById(R.id.tv_temperatura);
        tv_situacao = (TextView)findViewById(R.id.tv_situacao);
        tv_umidade = (TextView)findViewById(R.id.tv_umidade);

    }

    public void consulta_clique(View v)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Obtenho a API
        Api api = retrofit.create(Api.class);
        //Faço a chamada para a cidade de mirassol que é código 457599
        Call<Previsao> call = api.verPrevisao("457599");
        call.enqueue(new Callback<Previsao>() {
            @Override
            public void onResponse(Call<Previsao> call, Response<Previsao> response) {
                //Pego o retorno do Webservice, guardo numa variável e mostro
                Previsao retorno = response.body();
                String temperatura = retorno.results.temp;
                String situacao = retorno.results.description;
                String humidade = retorno.results.humidity;
                tv_temperatura.setText("Temperatura: " + temperatura + " graus");
                tv_situacao.setText(situacao);
                tv_umidade.setText("Umidade: " + humidade + "%");
            }
            @Override
            public void onFailure(Call<Previsao> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro de conexão...",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


}
