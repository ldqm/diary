package com.jinxi.rijiben;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    ListView lv1;
    Button btn1;
    private ListViewAdapter listViewAdapter;

    List<DiaryBean> diaryBeanList;
    DiaryBean diaryBean;
    private DBService dbService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbService = new DBService(this);
        lv1 = (ListView) findViewById(R.id.lv1);
        btn1 = findViewById(R.id.btn1);

        lv1.setOnItemClickListener(this);
        btn1.setOnClickListener(this);
        initData();



    }
    private void initData() {
        diaryBeanList = dbService.getDiaryAll();
        listViewAdapter = new ListViewAdapter(diaryBeanList,this);
        lv1.setAdapter(listViewAdapter);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.btn1){
            Intent intent = new Intent(MainActivity.this, TianjiajiemianActivity.class);
            startActivity(intent);


        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        diaryBean = diaryBeanList.get(position);
        Intent intent1 = new Intent(MainActivity.this, ChakanActivity.class);
        intent1.putExtra("id",diaryBean.getId());
        Log.e("onItemClick",diaryBean.getId() + "");
        startActivity(intent1);
    }
    //重启
    @Override
    protected void onRestart() {
        Log.e("TAG","onRestart");
        initData();
        super.onRestart();
    }
}