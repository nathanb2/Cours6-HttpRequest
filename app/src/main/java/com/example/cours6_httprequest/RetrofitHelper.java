package com.example.cours6_httprequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static APIService service = retrofit.create(APIService.class);

    public static APIService getRetrofitApiService() {
        return service;
    }
}
