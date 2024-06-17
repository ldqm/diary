package com.jinxi.rijiben;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBContact extends SQLiteOpenHelper {


    private static String sql = "create table Diary (" + "id integer primary key autoincrement, "
            + "year text, " + "month text, " + "day text,"  + "content text, "
            + "weather text, " + "mood text)";

    public DBContact(Context context) {
        super(context, "diary.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
