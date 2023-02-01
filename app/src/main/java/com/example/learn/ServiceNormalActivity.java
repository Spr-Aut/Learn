package com.example.learn;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.learn.service.NormalService;
import com.example.learn.util.DateUtil;


@SuppressLint("StaticFieldLeak")
public class ServiceNormalActivity extends AppCompatActivity implements View.OnClickListener {
    private static TextView tv_normal;
    private Intent mIntent; // 声明一个意图对象
    private static String mDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_normal);
        tv_normal = findViewById(R.id.tv_normal);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
        mDesc = "";
        // 创建一个通往普通服务的意图
        mIntent = new Intent(this, NormalService.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start -> startService(mIntent);
            case R.id.btn_stop -> stopService(mIntent);
        }
    }

    public static void showText(String desc) {
        if (tv_normal != null) {
            mDesc = String.format("%s%s %s\n", mDesc, DateUtil.getNowDateTime("HH:mm:ss"), desc);
            tv_normal.setText(mDesc);
        }
    }

}
