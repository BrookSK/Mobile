package br.gov.sp.etec.app_cep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LABINFO on 07/04/2022.
 */
public interface Api {
    String BASE_URL = "http://cep.republicavirtual.com.br/";

    @GET("web_cep.php?formato=json")
    Call<Dados> buscar(@Query("cep") String cep);
}
