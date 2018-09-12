package com.example.arunsingh.cad.rest;

import com.example.arunsingh.cad.model.remote.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMoview(@Query("api_key") String apiKey);

}
