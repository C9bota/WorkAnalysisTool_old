package com.example.mdd.wa_uiprototype;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static com.example.mdd.wa_uiprototype.MainActivity.FILE_NAME;


/**
 * A simple {@link Fragment} subclass.
 */
public class OutputFragment extends Fragment {


    public OutputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_output, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textViewCSV = view.findViewById(R.id.text_view_csv);
        textViewCSV.setText(readFromCSVFile());
    }

    String readFromCSVFile(){
        String resultStr = "";
        //読み出し
        FileInputStream fis;
        try {
            fis = getActivity().openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fis, StandardCharsets.UTF_8));
            while(reader.readLine() != null){
                resultStr += reader.readLine() +"\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultStr;
    }

}
