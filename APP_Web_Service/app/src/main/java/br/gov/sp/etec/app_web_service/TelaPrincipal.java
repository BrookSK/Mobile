package br.gov.sp.etec.app_web_service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaPrincipal extends AppCompatActivity {

    ListView lst_filmes;

    public static Filme filme_escolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        lst_filmes = (ListView)findViewById(R.id.lst_filmes);

        //Crio o Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //obtendo a API
        Api api = retrofit.create(Api.class);

        //Obtendo os dados
        Call<ArrayList<Filme>> call = api.getFilmes();

        //tratamento de retorno
        call.enqueue(new Callback<ArrayList<Filme>>() {
            @Override
            public void onResponse(Call<ArrayList<Filme>> call, Response<ArrayList<Filme>> response) {
                ArrayList<Filme> filmes = response.body();

                //Adaptador
                ArrayAdapter<Filme> adaptador = new ArrayAdapter<Filme>(getApplicationContext(),
                        R.layout.item, R.id.tv_filme, filmes);

                //Mostrando
                lst_filmes.setAdapter(adaptador);
            }

            @Override
            public void onFailure(Call<ArrayList<Filme>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Tente novamente...", Toast.LENGTH_SHORT).show();
            }
        });

        lst_filmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                filme_escolhido = (Filme)lst_filmes.getItemAtPosition(position);
                startActivity(new Intent(getApplication(), TelaDetalhe.class));
            }
        });
    }
}
