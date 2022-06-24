package com.example.todolist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class,version=1)
public abstract class NoteDataBase extends RoomDatabase {
    private static NoteDataBase instance;

    public static synchronized NoteDataBase getInstance(Context context) {
        if(instance==null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext()
            ,NoteDataBase.class,"note-database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }

    public abstract NoteDao noteDao();
}
