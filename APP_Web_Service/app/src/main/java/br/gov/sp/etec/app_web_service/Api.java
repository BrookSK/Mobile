package br.gov.sp.etec.app_web_service;

import retrofit2.Call;
import java.util.ArrayList;

import retrofit2.http.GET;

/**
 * Created by LABINFO on 24/03/2022.
 */
public interface Api {
    String BASE_URL="http://sujeitoprogramador.com/";

    //Arquivo
    @GET("r-api/?api=filmes")
    Call<ArrayList<Filme>>getFilmes();
}
