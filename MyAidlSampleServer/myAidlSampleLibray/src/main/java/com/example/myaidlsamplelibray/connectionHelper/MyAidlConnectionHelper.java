package com.example.myaidlsamplelibray.connectionHelper;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import com.example.myaidlsamplelibray.IMyAidlSampleInterface;

public class MyAidlConnectionHelper implements ServiceConnection {

    private final Context mContext;
    private IMyAidlSampleInterface myAidlSampleInterface = null;
    private static final String PACKAGE_NAME = "com.example.myaidlsampleserver";
    private static final String SERVICE_NAME = "com.example.myaidlsampleserver.Server.MyAidlService";

    public MyAidlConnectionHelper(Context context)
    {
        Log.d("MyAidlConnectionHelper", "Yogi MyAidlConnectionHelper Called ");
        mContext = context;
        onBindService();
    }

    public void onBindService()
    {
        boolean serviceConnected;
        Intent myIntent = new Intent();
        myIntent.setComponent(new ComponentName(PACKAGE_NAME,SERVICE_NAME));
        serviceConnected = mContext.bindService(myIntent,this,Context.BIND_AUTO_CREATE);
        Log.d("MyAidlConnectionHelper", "Yogi onBindService " + serviceConnected);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        myAidlSampleInterface = IMyAidlSampleInterface.Stub.asInterface(iBinder);
        Log.d("MyAidlConnectionHelper", "Yogi onServiceConnected " + componentName.getClassName());
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("MyAidlConnectionHelper", "Yogi onServiceDisconnected True ");
    }

    public IMyAidlSampleInterface getConnectionHelperInterface() {
        return myAidlSampleInterface;
    }
}
