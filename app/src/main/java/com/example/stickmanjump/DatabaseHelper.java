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
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
    }
    //metoda me insertu user ndatabaz
    public boolean insert(String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
}
