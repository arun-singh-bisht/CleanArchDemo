package com.example.arunsingh.cad.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.arunsingh.cad.dao.WordDAO;
import com.example.arunsingh.cad.model.Word;

/**
 * Created by Arun.Singh on 9/11/2018.
 */

@Database(entities = {Word.class},version = 1)
public abstract class WordDatabase extends RoomDatabase {

    public static WordDatabase instance;

    public abstract WordDAO getWordDAO();

    public static WordDatabase getinstance(Context context)
    {
        if(instance==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    WordDatabase.class, "word_database")
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

}
