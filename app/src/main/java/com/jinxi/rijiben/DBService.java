package com.jinxi.rijiben;

import android.content.Context;

import com.jinxi.rijiben.DiaryBean;

import java.util.List;

/**
 * 数据库服务类
 */
public class DBService {

    private DBOperation dbOperation;


    public DBService(Context context){

        dbOperation = new DBOperation(context);
    }

    public boolean addDiary(DiaryBean diaryBean){

        return dbOperation.addDiary(diaryBean);
    }


    public List<DiaryBean> getDiaryAll() {

        return dbOperation.getDiaryAll();
    }

    public DiaryBean getDiaryById(int id){

        return dbOperation.getDiaryById(id);
    }

    public boolean updateDiaryForId(DiaryBean diaryBean){
        return dbOperation.updateDiaryForId(diaryBean);
    }

    public boolean deleteDiaryForId(int id){

        return dbOperation.deleteDiaryForId(id);
    }

}
