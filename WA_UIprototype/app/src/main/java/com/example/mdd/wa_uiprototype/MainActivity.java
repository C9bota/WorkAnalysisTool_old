package com.example.mdd.wa_uiprototype;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Ui
    private RadioGroup rg1;
    private RadioGroup rg2;
    private RadioGroup rg3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg1 = findViewById(R.id.radioGroup1);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //radio groupらの値を拾ってくる
                int checkedId = rg1.getCheckedRadioButtonId();
                if(checkedId != -1){
                    RadioButton radioButton = findViewById(checkedId);
                    TextView textView = findViewById(R.id.textView);
                    String textgp = textView.getText().toString();
                    String textbt = radioButton.getText().toString();
                    Log.v("チェック済み",textgp + " " + textbt);
                }
            }
        });
    }
}
