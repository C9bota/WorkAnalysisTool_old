package com.example.a9bota.workanarisystool_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MakeRequestTask m_makeRequestTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI回り
        findViewById(R.id.send_button).setOnClickListener(this);

        m_makeRequestTask = new MakeRequestTask();

    }

    @Override
    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case R.id.send_button:
                    try {
                        m_makeRequestTask.putDataFromApi();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                default:
                    break;
            }
        }
    }



    

}
