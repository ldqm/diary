package com.jinxi.rijiben;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TianjiajiemianActivity extends AppCompatActivity {
    EditText et1;
    Button btntianqi,btnxinqing;
    TextView tvTime;

    private DBService dbService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tianjiajiemian);
    }
}