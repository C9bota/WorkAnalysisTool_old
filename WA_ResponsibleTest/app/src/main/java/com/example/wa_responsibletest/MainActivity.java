package com.example.wa_responsibletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private FragmentPagerAdapter adapter;
    private int curretPage;

    private TextView textViewCSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        curretPage = 0;

        //textViewCSV = findViewById(R.id.text_view_output);
        //textViewCSV = findViewById(R.id.text_view_input);

        writeToCSVFile("a,b,c\n");
        //readFromCSVFile();
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
            fos = openFileOutput(FILE_NAME, Context.MODE_APPEND);
            fis = openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis, StandardCharsets.UTF_8));

            Log.d("writeCSV", ("ファイルの一行目は"+reader.readLine()));
            if((reader.readLine()) == null){
                Log.d("writeCSV","中身が空っぽだよね");
                fos.write(("日時"+","+"項目１"+","+"項目２"+","+"項目３"+"\n").getBytes());
            }
            fos.write((writeTimeStr + "," + writedata).getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        Log.d("write","書き込み完了:" + writedata);

        //textReturn.setText("書き込みが完了しました " + writedata);
    }
//    //読み出し全般
    public final String FILE_NAME = "test.csv";
//    void readFromCSVFile(){
//        //読み出し
//        FileInputStream fis;
//        try {
//            fis = openFileInput(FILE_NAME);
//
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(fis, StandardCharsets.UTF_8));
//            String str ="";
//            while(reader.readLine() != null){
//                str += reader.readLine() +"\n";
//
//            }
//            textViewCSV.setText(str);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//    }



}
