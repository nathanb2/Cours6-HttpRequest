package com.example.cours6_httprequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Interface ou l'on declare toute nos request
 * pour chacune:
 * 1er ligne : annotation qui indique la methode Http de la request et son complement d'url particulier
 * 2e ligne : declaration de la fonction qui prend en parametre les parametre de la request grace a des annotation (@Path, @Body, @Query, @Header)
 * et retourne un objet de type Call qui est LA request a qui on indique le type de la reponse attendu
 */
public interface APIService {

    @GET("users/{username}/following")
    Call<List<GithubUser>> getFollowing(@Path("username") String username);

}
