package com.example.arunsingh.cad;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.arunsingh.cad.adapters.MovieListAdapter;
import com.example.arunsingh.cad.model.remote.Movie;
import com.example.arunsingh.cad.viewmodel.MovieViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesActivity extends AppCompatActivity {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private String TAG ="MoviesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moviews);

        // bind the view using butterknife
        ButterKnife.bind(this);

        initRecycleView();
    }



    private void initRecycleView()
    {
        //step 2: use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //step 3: specify an adapter
        final MovieListAdapter movieListAdapter = new MovieListAdapter();
        mRecyclerView.setAdapter(movieListAdapter);

        MovieViewModel movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getTopRatedMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                movieListAdapter.setData(movies);
            }
        });

    }

}
