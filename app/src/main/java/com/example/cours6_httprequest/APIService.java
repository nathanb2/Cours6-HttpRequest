package com.example.cours6_httprequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {

    @GET("users/{username}/following")
    Call<List<GithubUser>> getFollowing(@Path("username") String username);

}
