package com.example.arunsingh.cad.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.arunsingh.cad.R;
import com.example.arunsingh.cad.model.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arun.Singh on 9/11/2018.
 */

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder>{

    private List<Word> wordList = new ArrayList<>();

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View vIew = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_layout, parent, false);

        WordViewHolder wordViewHolder = new WordViewHolder(vIew);
        wordViewHolder.textView_word = vIew.findViewById(R.id.txt_word);
        wordViewHolder.textView_description = vIew.findViewById(R.id.txt_description);

        return wordViewHolder;
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Word word = wordList.get(position);
        holder.textView_word.setText(word.getWord());
        holder.textView_description.setText(word.getDescription());
    }

    @Override
    public int getItemCount() {
        return wordList.size();
    }

    public void setData(List<Word> wordList)
    {
        this.wordList = wordList;
        this.notifyDataSetChanged();
    }


    class WordViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView_word;
        TextView textView_description;
        public WordViewHolder(View itemView) {
            super(itemView);

        }
    }
}
