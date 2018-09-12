package com.example.arunsingh.cad.repositiry;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.arunsingh.cad.dao.WordDAO;
import com.example.arunsingh.cad.database.WordDatabase;
import com.example.arunsingh.cad.model.local.Word;

import java.util.List;

/**
 * Created by Arun.Singh on 9/11/2018.
 */

public class WordRepository {

    private  WordDAO wordDAO;
    public WordRepository(Application application) {

        WordDatabase db = WordDatabase.getinstance(application);
        wordDAO = db.getWordDAO();
    }

    public void addNewWord(Word word)
    {
        //If Network available -> post data to server
        //else -> save into Local DB
        new AsynAddNewWord(wordDAO).execute(word);
    }

    public LiveData<List<Word>> getAllWords()
    {
        //IF Latest data is available in DB fetch from Local DB
        //else fetch from server and save into local db
        return wordDAO.getAllWords();
    }

    public void deleteAllWord()
    {
        wordDAO.deleteAllWords();
    }

    class AsynAddNewWord extends AsyncTask<Word,Void,Void>
    {
        private WordDAO wordDAO;
        public AsynAddNewWord(WordDAO wordDAO) {
            this.wordDAO = wordDAO;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Word... words) {

            Word word = words[0];
            wordDAO.addNewWord(word);
            return null;
        }

    }

}
