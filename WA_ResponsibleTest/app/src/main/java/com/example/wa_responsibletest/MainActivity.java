package com.example.wa_responsibletest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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

        textViewCSV = findViewById(R.id.text_view_output);

        //writeToCSVFile();
        readFromCSVFile();
    }


    //読み出し全般
    public final String FILE_NAME = "test.csv";
    void readFromCSVFile(){
        //読み出し
        FileInputStream fis;
        try {
            fis = openFileInput(FILE_NAME);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis, StandardCharsets.UTF_8));
            String str ="";
            while(reader.readLine() != null){
                str += reader.readLine() +"\n";
                textViewCSV.setText(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
