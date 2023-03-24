package com.example.myaidlsamplecilent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myaidlsamplelibray.IMyAidlSampleInterface;
import com.example.myaidlsamplelibray.connectionHelper.MyAidlConnectionHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView OutputStr;
    private EditText edFirstNum;
    private EditText edSecondNum;
    private Button AddBtn;
    private Button SubBtn;
    private Button MultipleBtn;
    private Button DivideBtn;
    private Button startServiceBtn;
    MyAidlConnectionHelper myAidlConnectionHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OutputStr = (TextView) findViewById(R.id.outputStr);
        AddBtn = (Button) findViewById(R.id.Add_button);
        SubBtn = (Button) findViewById(R.id.Sub_button);
        MultipleBtn = (Button) findViewById(R.id.multiply_Button);
        DivideBtn = (Button) findViewById(R.id.divide_Button);
        edFirstNum = (EditText) findViewById(R.id.EditFirstNum);
        edSecondNum = (EditText) findViewById(R.id.EditSecondNum);
        startServiceBtn = (Button) findViewById(R.id.startActivity);

        AddBtn.setOnClickListener(this);
        SubBtn.setOnClickListener(this);
        MultipleBtn.setOnClickListener(this);
        DivideBtn.setOnClickListener(this);
        startServiceBtn.setOnClickListener(this);
    }

    private void startMainActivity() {
        Log.d("MainActivity "," Yogi Main Activity Called ");
        myAidlConnectionHelper = new MyAidlConnectionHelper(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.Add_button: CalculatorData(1); break;
            case R.id.Sub_button: CalculatorData(2); break;
            case R.id.multiply_Button: CalculatorData(3); break;
            case R.id.divide_Button: CalculatorData(4); break;
            case R.id.startActivity: startMainActivity(); break;
        }
    }

    private void CalculatorData(int i) {
        int firtNum = Integer.parseInt(edFirstNum.getText().toString());
        int SecondNum = Integer.parseInt(edSecondNum.getText().toString());
        int outputNum = 0;
        switch (i)
        {
            case 1 :
            {
                try {
                    outputNum =  myAidlConnectionHelper.getConnectionHelperInterface().onAddCommand(firtNum,SecondNum);
                }
                catch (RemoteException e)
                {
                    e.printStackTrace();
                }
            }
            break;
            case 2 :
            {
                try {
                    outputNum =  myAidlConnectionHelper.getConnectionHelperInterface().onSubCommand(firtNum,SecondNum);
                }
                catch (RemoteException e)
                {
                    e.printStackTrace();
                }
            }
            break;
            case 3 :
            {
                try {
                    outputNum =  myAidlConnectionHelper.getConnectionHelperInterface().onMultiplyCommand(firtNum,SecondNum);
                }
                catch (RemoteException e)
                {
                    e.printStackTrace();
                }
            }
            break;
            case 4 :
            {
                try {
                    outputNum =  myAidlConnectionHelper.getConnectionHelperInterface().onDivideCommand(firtNum,SecondNum);
                }
                catch (RemoteException e)
                {
                    e.printStackTrace();
                }
            }
            break;
        }
        OutputStr.setText("Output : " + outputNum);
    }
}