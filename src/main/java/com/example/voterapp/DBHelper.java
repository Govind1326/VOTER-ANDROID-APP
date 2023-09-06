package com.example.voterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="REGISTR.db";

    public DBHelper(Context context) {
        super(context, "REGISTR.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
        Mydb.execSQL("create  table usr(id INTEGER primary key autoincrement," +
                "name TEXT," +
                "email TEXT," +
                "age INTEGER)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
        Mydb.execSQL("drop table if exists usr");
    }

    public boolean insertdata(String name,String email,String age){
        SQLiteDatabase Mydb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("email",email);
        cv.put("age",age);

        long r=Mydb.insert("usr",null,cv);
        Mydb.close();
        if(r>0)
            return true;
        else
            return false;
        }


    }

