package com.example.stickmanjump;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper (Context context){
        super(context,"Login.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("Create table user(id integer primary key autoincrement,email text,password text)");

    }
}
