package com.example.myaidlsampleserver.Server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.myaidlsampleserver.Server.binder.MyAidlBinder;

public class MyAidlService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("MyAidlService ","Yogi - MyAidlService onBind Called ");
        return MyAidlBinder.getInstance();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyAidlService ","Yogi - MyAidlService OnCreate Called ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyAidlService ","Yogi - MyAidlService onStartCommand Called ");
        return super.onStartCommand(intent, flags, startId);
    }
}