package com.jinxi.rijiben;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.jinxi.rijiben.DiaryBean;

import java.util.ArrayList;
import java.util.List;

public class DBOperation {

    private DBContact dbContact = null;

    private int id;
    private String year;
    private String monthday;
    private String content;
    private String weather;
    private String mood;

    public DBOperation(Context context){

        dbContact = new DBContact(context);
    }


    /**
     * 添加数据
     * @param diaryBean
     * @return
     */
    public boolean addDiary(DiaryBean diaryBean){
        SQLiteDatabase sqLiteDatabase = dbContact.getWritableDatabase();
        if (diaryBean != null){
            ContentValues value = new ContentValues();
            value.put("year", diaryBean.getYear());
            value.put("month", diaryBean.getMonth());
            value.put("day", diaryBean.getDay());
            value.put("content", diaryBean.getContent());
            value.put("weather", diaryBean.getWeather());
            value.put("mood", diaryBean.getMood());
            sqLiteDatabase.insert("Diary",null,value);
            return true;
        }else {
            return false;
        }
    }

    /**
     * 获取所有数据
     * @return
     */
    public List<DiaryBean> getDiaryAll() {
        List<DiaryBean> diaryBeans = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbContact.getReadableDatabase();
        String sql = "select * from Diary";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                DiaryBean diaryBean = new DiaryBean();
                diaryBean.setId(cursor.getInt(0));
                diaryBean.setYear(cursor.getString(1));
                diaryBean.setMonth(cursor.getString(2));
                diaryBean.setDay(cursor.getString(3));
                diaryBean.setContent(cursor.getString(4));
                diaryBean.setWeather(cursor.getString(5));
                diaryBean.setMood(cursor.getString(6));
                diaryBeans.add(diaryBean);

                Log.e("getContent", cursor.getString(3) + "");
            }
            return diaryBeans;
        }
        return null;
    }

    /**
     * 通过Id获取数据
     * @param id
     * @return
     */
    public DiaryBean getDiaryById(int id){
        DiaryBean diaryBean = new DiaryBean();
        Log.e("TAG", id +"");
        SQLiteDatabase sqLiteDatabase = dbContact.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from Diary where id = ?", new String[]{String.valueOf(id)});
        if (cursor.getCount() != 0) {

            while (cursor.moveToNext()){
                diaryBean.setId(cursor.getInt(0));
                diaryBean.setYear(cursor.getString(1));
                diaryBean.setMonth(cursor.getString(2));
                diaryBean.setDay(cursor.getString(3));
                diaryBean.setContent(cursor.getString(4));
                diaryBean.setWeather(cursor.getString(5));
                diaryBean.setMood(cursor.getString(6));


                Log.e("getDiaryById", cursor.getString(4) + "");
            }
            cursor.close();
            dbContact.close();



            return diaryBean;
        }

        return null;
    }


    /**
     * 通过Id更新数据
     * @param diaryBean
     * @return
     */
    public boolean updateDiaryForId(DiaryBean diaryBean) {
        SQLiteDatabase sqLiteDatabase = dbContact.getWritableDatabase();
        Log.e("updateDiaryForId",id + "");
        ContentValues value = new ContentValues();

        value.put("year", diaryBean.getYear());
        value.put("month", diaryBean.getMonth());
        value.put("day", diaryBean.getDay());
        value.put("content", diaryBean.getContent());
        value.put("weather", diaryBean.getWeather());
        value.put("mood", diaryBean.getMood());

//        sqLiteDatabase.execSQL("update from Diary where id = ?", new String[]{String.valueOf(diaryBean.getId())});
        sqLiteDatabase.update("Diary", value, "id=?", new String[]{String.valueOf(diaryBean.getId())});
        return true;
    }

    /**
     * 通过Id删除数据
     * @param id
     * @return
     */
    public boolean deleteDiaryForId(int id){
        SQLiteDatabase sqLiteDatabase = dbContact.getWritableDatabase();
        Log.e("deleteDiaryForId",id + "");
        sqLiteDatabase.execSQL("delete from Diary where id = ?", new String[]{String.valueOf(id)});
        return true;
    }

}
