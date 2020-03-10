package com.example.mysqltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_view);

        try{
            //データベースに接続
            Connection connection = MySqlConnect.getConnection();
            //ステートメントオブジェクトを作成
            Statement statement = connection.createStatement();

            //SQL部分
            String mysql = "select date from table;";
            ResultSet resultSet = statement.executeQuery(mysql);

            while (resultSet.next()){
                textView.setText(resultSet.getString("date"));
            }

            //オブジェクトの解放
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
