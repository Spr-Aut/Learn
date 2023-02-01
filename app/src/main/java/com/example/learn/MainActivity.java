package com.example.learn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final static String STANDARD_ACTION="com.example.app.main";
    private final static String ALARM_ACTION="com.example.app.main.alarm";
    private String mReceive="标准广播的收听信息";
    private StandardReceiver standardReceiver;
    private AlarmReceiver alarmReceiver;
    private TextView textView;
    private TextView textView1;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tv_hello);
        textView.setText("你好");
        textView.setTextColor(Color.GREEN);

        textView1=findViewById(R.id.tv_alarm);
        textView1.setText("你好");
        textView1.setTextColor(Color.GREEN);

        Button button=findViewById(R.id.btn_test);
        button.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        standardReceiver=new StandardReceiver();
        IntentFilter filter=new IntentFilter(STANDARD_ACTION);
        registerReceiver(standardReceiver,filter);

        alarmReceiver=new AlarmReceiver();
        IntentFilter filter1=new IntentFilter(ALARM_ACTION);
        registerReceiver(alarmReceiver,filter1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(standardReceiver);
        unregisterReceiver(alarmReceiver);
    }

    private void clickEvent() {

        /*Toast.makeText(MainActivity.this,"点击了按钮",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:15583202813"));
        startActivity(intent);*/

        Intent intent=new Intent(STANDARD_ACTION);
        sendBroadcast(intent);

        sendAlarm();

    }

    private void sendAlarm() {
        Intent intent1=new Intent(ALARM_ACTION);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent1,PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        long delayTime=System.currentTimeMillis()+2*1000;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,delayTime,pendingIntent);
        }else {

        }
        alarmManager.set(AlarmManager.RTC_WAKEUP,delayTime,pendingIntent);
    }

    private class StandardReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent!=null&&intent.getAction().equals(STANDARD_ACTION)){
                mReceive=String.format("%s\n 收到一个广播", count);
                textView.setText(mReceive);
                count++;
                Log.d("MyBroadcast",count+"");
            }
        }
    }

    public class AlarmReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent!=null&&intent.getAction().equals(ALARM_ACTION)){
                textView1.setText("naozhong");
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test -> clickEvent();
        }
    }
}