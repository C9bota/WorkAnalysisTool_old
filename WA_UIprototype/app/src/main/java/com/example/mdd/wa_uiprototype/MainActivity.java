package com.example.mdd.wa_uiprototype;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    //Ui
//    private RadioGroup rg1;
//    private RadioGroup rg2;
//    private RadioGroup rg3;
//
    private RadioGroup[] radioGroups = new RadioGroup[3];
    private TextView[] textViews = new TextView[3];

    //CSV用
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\r\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        rg1 = findViewById(R.id.radioGroup1);
//        rg2 = findViewById(R.id.radioGroup2);
//        rg3 = findViewById(R.id.radioGroup3);

        radioGroups[0] = findViewById(R.id.radioGroup1);
        radioGroups[1] = findViewById(R.id.radioGroup2);
        radioGroups[2] = findViewById(R.id.radioGroup3);

        textViews[0] = findViewById(R.id.textView);
        textViews[1] = findViewById(R.id.textView2);
        textViews[2] = findViewById(R.id.textView3);


        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //radio groupらの値を拾ってくる
//                int checkedId = rg1.getCheckedRadioButtonId();
//                if(checkedId != -1){
//                    RadioButton radioButton = findViewById(checkedId);
//                    TextView textView = findViewById(R.id.textView);
//                    String textgp = textView.getText().toString();
//                    String textbt = radioButton.getText().toString();
//                    Log.v("チェック済み",textgp + " " + textbt);
//                }

                String datastr = "";
                for(int i=0; i<radioGroups.length; i++){
                    int checkedId = radioGroups[i].getCheckedRadioButtonId();
                    if(checkedId != -1){
                        RadioButton radioButton = findViewById(checkedId);

                        String textgp = textViews[i].getText().toString();
                        String textbt = radioButton.getText().toString();
                        datastr += textbt;
                        //Log.v("チェック済み",textgp + " " + textbt);
                    }
                }

                //writeToCSVFile();
                //writeToCSVFile2();
                writeToCSVFile3("項目１,項目２,項目3\n");
                writeToCSVFile3(datastr);
            }
        });
    }

    void writeToCSVFile(){
        try{
            //出力先の作成
            Context context = this;
            FileWriter fw = new FileWriter(Environment.getDataDirectory().getPath()+"/test.csv",false);
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

            //内容を指定する
            pw.print("あ");
            pw.print(",");
            pw.print("い");
            pw.println();

            pw.print("01");
            pw.print(",");
            pw.print("02");
            pw.println();

            //ファイルに書き出す
            pw.close();

            //終了メッセージを画面に出力する
            System.out.println("出力が完了しました。");
       } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    void writeToCSVFile2(){
        try {
            FileOutputStream fileOutputStream = openFileOutput("test.csv", Context.MODE_PRIVATE);
            fileOutputStream.write("a,b,c".getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeToCSVFile3(String writedata){
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("test.csv", Context.MODE_PRIVATE);
            fos.write(writedata.getBytes());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("write","書き込み完了:" + writedata);
    }
}
