package com.example.mdd.wa_uiprototype;

import android.app.Activity;
import android.content.Context;
import android.os.Debug;
import android.os.Environment;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RadioGroup[] radioGroups = new RadioGroup[3];
    private TextView[] textViews = new TextView[3];
    private TextView textReturn;
    private TextView textCSVData;

    //CSV用
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\r\n";
    private static final String FILE_NAME = "test.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroups[0] = findViewById(R.id.radioGroup1);
        radioGroups[1] = findViewById(R.id.radioGroup2);
        radioGroups[2] = findViewById(R.id.radioGroup3);

        textViews[0] = findViewById(R.id.textView);
        textViews[1] = findViewById(R.id.textView2);
        textViews[2] = findViewById(R.id.textView3);

        textReturn = findViewById(R.id.textViewReturn);
        textCSVData = findViewById(R.id.textViewData);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String datastr = "";
                for(int i=0; i<radioGroups.length; i++){
                    int checkedId = radioGroups[i].getCheckedRadioButtonId();
                    if(checkedId != -1){
                        RadioButton radioButton = findViewById(checkedId);

                        String textgp = textViews[i].getText().toString();
                        String textbt = radioButton.getText().toString();
                        datastr += textbt;
                        if(i<radioGroups.length-1){
                            datastr += COMMA;
                        }else{
                            datastr += NEW_LINE;
                        }
                    }
                }
                writeToCSVFile(datastr);
            }
        });
    }


    void writeToCSVFile(String writedata){
        FileOutputStream fos = null;
        FileInputStream fis = null;
        Calendar writeTime = Calendar.getInstance(Locale.JAPAN);
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd_hh:mm:ss");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

        //書き込み
        String writeTimeStr = sdf.format(writeTime.getTime());
        try {
            fos = openFileOutput(FILE_NAME,Context.MODE_APPEND);
            fis = openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis, StandardCharsets.UTF_8));

            Log.d("writeCSV", ("ファイルの一行目は"+reader.readLine()));
            if((reader.readLine()) == null){
                Log.d("writeCSV","中身が空っぽだよね");
                fos.write(("日時"+COMMA+"項目１"+COMMA+"項目２"+COMMA+"項目３"+NEW_LINE).getBytes());
            }
            fos.write((writeTimeStr + COMMA + writedata).getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        //読み出し
        try {
            fis = openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis, StandardCharsets.UTF_8));
            String str ="";
            while(reader.readLine() != null){
                str += reader.readLine() +"\n";
                textCSVData.setText(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        Log.d("write","書き込み完了:" + writedata);
        textReturn.setText("書き込みが完了しました " + writedata);
    }
}
