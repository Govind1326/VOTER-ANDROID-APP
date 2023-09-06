package com.example.voterapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Result extends SQLiteOpenHelper {
    public static final String DBNAME="RESULT.db";

    public Result(Context context) {
        super(context, "RESULT.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {

        Mydb.execSQL("create table Vote_Count(id INTEGER primary key autoincrement,bjpvote integer,cgsvote integer)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
        Mydb.execSQL("drop table if exists Vote_Count");

    }
    public boolean insertvote(String bjp,String cgs){
        SQLiteDatabase Mydb=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("bjpvote",bjp);
        cv.put("cgsvote",cgs);

        long r=Mydb.insert("Vote_Count",null,cv);
        Mydb.close();
        if(r>0)
            return true;
        else
            return false;
    }
    public Cursor view_data(){
    SQLiteDatabase db=this.getReadableDatabase();
    String q="select sum(bjpvote),sum(cgsvote) from Vote_Count";
    Cursor cr=db.rawQuery(q,null);
    return cr;
    }

}
