package com.example.mdd.wa_uiprototype;

import java.util.Date;

//項目1~3と入力時刻を保持するためのクラス

public class Data {
    private Date date;
    private String item1;
    private String item2;
    private String item3;

    public Data(Date date, String item1, String item2, String item3){
        this.date=date;
        this.item1=item1;
        this.item2=item2;
        this.item3=item3;
    }


}
