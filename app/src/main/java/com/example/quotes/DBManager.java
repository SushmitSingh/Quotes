package com.example.quotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBManager  extends SQLiteOpenHelper {
    private static final String dbname="QuoteDb";
    public DBManager(@Nullable Context context) {
        super(context, dbname, null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table tbl_quote (id integer primary key autoincrement, quote text, tag text)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String qry="DROP TABLE IF EXISTS tbl_quote";
        db.execSQL(qry);
        onCreate(db);

    }
    public String addRecord(String quote,String tag){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("quote",quote);
        contentValues.put("tag",tag);
        float res=database.insert("tbl_quote",null,contentValues);
        if(res==-1){
            return "failed";
        }
        else {
            Log.d(String.valueOf(res),"sucess");
            return "success";
        }
    }
    public Cursor readAllData(){
        SQLiteDatabase database=this.getWritableDatabase();
        String qry="SELECT * FROM tbl_quote ORDER BY id DESC";
        Cursor cursor=database.rawQuery(qry,null);
        return cursor;
    }
    public void deleteOnerecord(String quote){
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete("tbl_quote", "quote" + " = ?", new String[] {quote});
        db.close();
    }



}
