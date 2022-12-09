package com.example.finalconqueringfirebase.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finalconqueringfirebase.Models.Notes;

@Database(entities = Notes.class, version = 1, exportSchema = false)
public abstract class dataBaseR extends RoomDatabase {
    private static dataBaseR database;
    private static String DATABASE_NAME = "NoteApp";

    public synchronized static dataBaseR getInstance(Context context)
    {
        if(database == null) {
            database = Room.databaseBuilder(context.getApplicationContext(),
                    dataBaseR.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
    public abstract MainDataAccessObject mainDataAccessObject();
}
