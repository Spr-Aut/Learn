package com.example.learn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.learn.ServiceNormalActivity;

public class NormalService extends Service {
    public NormalService() {
    }

    private void refresh(String text){
        ServiceNormalActivity.showText(text);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        refresh("onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        refresh("onStartCommand.flags="+flags);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        refresh("onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        refresh("onBind");
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        refresh("onRebind");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        refresh("onUnbind");
        return true;
    }
}