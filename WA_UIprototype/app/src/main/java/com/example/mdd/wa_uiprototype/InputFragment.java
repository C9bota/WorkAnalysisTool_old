package com.example.mdd.wa_uiprototype;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

import static com.example.mdd.wa_uiprototype.MainActivity.COMMA;
import static com.example.mdd.wa_uiprototype.MainActivity.FILE_NAME;
import static com.example.mdd.wa_uiprototype.MainActivity.NEW_LINE;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {

    public InputFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonInput = view.findViewById(R.id.button_input);
        buttonInput.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("InputFragment","Click on ButtonInput");
                readFromUI();
            }
        });

    }

    void readFromUI(){
        //データをUIから拾うい集めdatastrに格納
        String datastr = "a,b,c\n";
        /*
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
        }*/
        writeToCSVFile(datastr);
    }

    void writeToCSVFile(String writedata){
        FileOutputStream fos = null;
        FileInputStream fis = null;
        Calendar writeTime = Calendar.getInstance(Locale.JAPAN);
        SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd_hh:mm:ss");

        //書き込み
        String writeTimeStr = sdf.format(writeTime.getTime());
        try {
            fos = getActivity().openFileOutput(FILE_NAME, Context.MODE_APPEND);

            //空のファイルかどうかを確認
            fis = getActivity().openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis, StandardCharsets.UTF_8));
            Log.d("writeCSV", ("ファイルの一行目は"+reader.readLine()));
            if((reader.readLine()) == null){
                Log.d("writeCSV","中身が空っぽだよね");
                fos.write(("日時"+COMMA+"項目１"+COMMA+"項目２"+COMMA+"項目３"+NEW_LINE).getBytes());
            }

            //項目の書き込み
            fos.write((writeTimeStr + COMMA + writedata).getBytes());
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
}
