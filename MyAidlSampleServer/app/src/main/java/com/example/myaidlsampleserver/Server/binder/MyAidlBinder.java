package com.example.myaidlsampleserver.Server.binder;


import android.os.RemoteException;
import android.util.Log;

import com.example.myaidlsamplelibray.IMyAidlSampleInterface;

public class MyAidlBinder extends IMyAidlSampleInterface.Stub {

    private static MyAidlBinder myAidlBinder = null;

    public static MyAidlBinder getInstance() {
        Log.d("MyAidlBinder ","Yogi - MyAidlBinder getInstance Called ");
        if(myAidlBinder == null) {
            myAidlBinder = new MyAidlBinder();
        }
        return myAidlBinder;
    }

    @Override
    public int onAddCommand(int firstnum, int Secondnum) throws RemoteException {
        return (firstnum + Secondnum);
    }

    @Override
    public int onSubCommand(int firstnum, int Secondnum) throws RemoteException {
        int ret = 0;
        if(firstnum > Secondnum)
        {
            ret = firstnum - Secondnum;
        }
        else
        {
            ret = Secondnum - firstnum;
        }
        return ret;
    }

    @Override
    public int onMultiplyCommand(int firstnum, int Secondnum) throws RemoteException {
        return (firstnum * Secondnum);
    }

    @Override
    public int onDivideCommand(int firstnum, int Secondnum) throws RemoteException {
        return (firstnum/Secondnum);
    }

    @Override
    public int calculationMethod(int firstnum, int Secondnum, int OperationType) throws RemoteException {
        return calculsMethod(firstnum,Secondnum,OperationType);
    }

    private int calculsMethod(int firstnum, int secondnum, int operationType) {
        int ret_val = 0;
        switch (operationType)
        {
            case 1 : ret_val = firstnum + secondnum; break;
            case 2 : if(firstnum > secondnum) ret_val = firstnum - secondnum; else ret_val = secondnum - firstnum;
            case 3 : ret_val = firstnum * secondnum; break;
            case 4: ret_val = firstnum/secondnum; break;
            default: ret_val = 0;
        }
        return ret_val;
    }
}
