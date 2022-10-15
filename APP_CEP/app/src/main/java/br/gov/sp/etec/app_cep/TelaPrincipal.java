package br.gov.sp.etec.app_cep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TelaPrincipal extends AppCompatActivity {

    EditText edit_logradouro, edit_bairro, edit_cidade, edit_cep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        edit_logradouro = (EditText)findViewById(R.id.edit_logradouro);
        edit_bairro = (EditText)findViewById(R.id.edit_bairro);
        edit_cidade = (EditText)findViewById(R.id.edit_cidade);
        edit_cep = (EditText)findViewById(R.id.edit_cep);
    }

    public void consultar_clique(View v){
        String cep = edit_cep.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Dados> call = api.buscar(cep);

        call.enqueue(new Callback<Dados>() {
            @Override
            public void onResponse(Call<Dados> call, Response<Dados> response) {
                Dados dados = response.body();

                edit_bairro.setText(dados.getBairro());
                edit_cidade.setText(dados.getCidade() +"-"+ dados.getUf());
                edit_logradouro.setText(dados.getTipo_logradouro() +" "+ dados.getLogradouro());
            }

            @Override
            public void onFailure(Call<Dados> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Tente mais tarde", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
