package com.example.stickmanjump;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        
        long ins = db.insert("user",null,contentValues);
        if(ins == -1) return false;
        else return true;
}
    //metoda me check a ekziston emaili

    public boolean chkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where email=?",new String[]{email});
        if(cursor.getCount()>0) return false;
        else return true;
    }
    //me ba check tash emailin edhe passwordin per mu logu
        public Boolean emailpassword(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase()
