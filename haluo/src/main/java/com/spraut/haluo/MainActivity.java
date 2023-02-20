package com.spraut.haluo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private String packageName="com.example.chapter13";//com.jingyao.easybike
    private String className="com.example.chapter13.MainActivity";//com.hellobike.platform.scan.v2.NewPlatformScanActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
        //TextView tvTest=findViewById(R.id.tv_test);
        //tvTest.setOnClickListener(v -> turnTo());
        //turnTo();

    }
    private void turnTo(){
        Intent intent=new Intent();
        ComponentName cn=new ComponentName(packageName,className);
        intent.setComponent(cn);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }
}