package com.example.mysqltest;

import java.sql.*;
public class MySqlConnect {
    static Connection getConnection() throws Exception{
        //JDBCドライバのロード
        Class.forName("com.mysql.jdbc.Driver");

        //各種設定
        String url = "jdbc:mysql://183.181.84.203/mysql8051.xserver.jp";
        String user ="wdy_test";
        String pass = "hogefuga";

        //DBに接続
        Connection connection = DriverManager.getConnection(url,user,pass);
        return connection;
    }
}