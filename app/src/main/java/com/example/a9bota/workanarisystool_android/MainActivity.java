package com.example.a9bota.workanarisystool_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //UI回り
        findViewById(R.id.send_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view != null) {
            switch (view.getId()) {
                case R.id.send_button:
                    sendToSpreadsheet();
                    break;
                default:
                    break;
            }
        }
    }

    

}
