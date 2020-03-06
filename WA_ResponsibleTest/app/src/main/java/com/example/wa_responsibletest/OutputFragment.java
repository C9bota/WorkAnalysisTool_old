package com.example.wa_responsibletest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class OutputFragment extends Fragment {

    TextView textViewCSV;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_output, container, false);
        //FrameLayout v = (FrameLayout) inflater.inflate(R.layout.fragment_output, container, false);
        //textViewCSV = v.findViewById(R.id.text_view_output);
        //textViewCSV = getView().findViewById(R.id.text_view_output);
//        readFromCSVFile();
        return v;
    }

//    //読み出し全般
//    public final String FILE_NAME = "test.csv";
//    void readFromCSVFile(){
//        //読み出し
//        FileInputStream fis;
//        try {
//            fis = getActivity().openFileInput(FILE_NAME);
//
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(fis, StandardCharsets.UTF_8));
//            String str ="";
//            while(reader.readLine() != null){
//                str += reader.readLine() +"\n";
//                textViewCSV.setText(str);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


}
