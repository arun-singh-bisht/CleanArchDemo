package com.example.arunsingh.cad;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.arunsingh.cad.adapters.WordAdapter;
import com.example.arunsingh.cad.model.Word;
import com.example.arunsingh.cad.viewmodel.WordViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private WordAdapter wordAdapter;
    private int REQUEST_CODE_ADD_NEW_WORD = 1001;
    private String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind the view using butterknife
        ButterKnife.bind(this);

        initRecycleView();
    }

    @OnClick(R.id.fab)
    public void onFabClick()
    {
        //Open New Activity To Add new Item
        Intent intent = new Intent(MainActivity.this,AddWordActivity.class);
        startActivityForResult(intent,REQUEST_CODE_ADD_NEW_WORD);
    }

    private void initRecycleView()
    {
        //step 2: use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //step 3: specify an adapter
        wordAdapter = new WordAdapter();
        //wordAdapter.setData(getWordsList());
        mRecyclerView.setAdapter(wordAdapter);


        WordViewModel wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        wordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {

                Log.i(TAG,"onChanged "+words.size());
                wordAdapter.setData(words);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE_ADD_NEW_WORD && resultCode==RESULT_OK)
        {
            String new_word =data.getStringExtra("new_word");
            String new_description =data.getStringExtra("new_description");
            Word word = new Word(new_word,new_description);

            //save new word in Database
            WordViewModel wordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
            wordViewModel.addNewWord(word);
        }

    }

}
