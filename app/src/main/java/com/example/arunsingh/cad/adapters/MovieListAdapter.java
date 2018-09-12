package com.example.arunsingh.cad.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arunsingh.cad.R;
import com.example.arunsingh.cad.model.remote.Movie;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {

    private List<Movie> movieList = new ArrayList<>();

    class MovieViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.txt_title)
        TextView txt_title;

        @BindView(R.id.txt_release_Date)
        TextView txt_release_Date;

        @BindView(R.id.txt_rating)
        TextView txt_rating;

        @BindView(R.id.txt_about)
        TextView txt_about;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movie_layout, null);
        MovieViewHolder movieViewHolder = new MovieViewHolder(view);

        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.txt_title.setText(movieList.get(position).getTitle());
        holder.txt_release_Date.setText(movieList.get(position).getRelease_date());
        holder.txt_rating.setText(movieList.get(position).getVote_average());
        holder.txt_about.setText(movieList.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setData(List<Movie> movieList)
    {
        this.movieList = movieList;
        notifyDataSetChanged();
    }
}
