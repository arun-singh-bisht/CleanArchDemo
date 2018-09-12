package com.example.arunsingh.cad.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.arunsingh.cad.model.remote.Movie;
import com.example.arunsingh.cad.repositiry.MovieRepository;

import java.util.List;

public class MovieViewModel extends AndroidViewModel{

    private MovieRepository movieRepository;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieRepository = MovieRepository.getInstance();
    }

    public LiveData<List<Movie>> getTopRatedMovies()
    {
        return movieRepository.getTopRatedMovies();

    }
}
