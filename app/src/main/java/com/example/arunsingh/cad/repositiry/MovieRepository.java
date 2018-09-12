package com.example.arunsingh.cad.repositiry;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.arunsingh.cad.model.remote.Movie;
import com.example.arunsingh.cad.model.remote.MovieResponse;
import com.example.arunsingh.cad.rest.ApiClient;
import com.example.arunsingh.cad.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private static MovieRepository instance;

    public static MovieRepository getInstance()
    {
        if(instance ==null)
        {
            instance = new MovieRepository();
        }
        return instance;
    }

    private MovieRepository()
    {}

    public LiveData<List<Movie>> getTopRatedMovies()
    {
        //Get From Local DB
        //---------------


        //Get From Remote Server
        //--------------
        final MutableLiveData<List<Movie>> data = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> topRatedMoview = apiInterface.getTopRatedMoview(ApiClient.API_KEY);
        topRatedMoview.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> results = response.body().getResults();
                data.setValue(results);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        return data;
    }
}
