package com.example.a9bota.workanarisystool_android;

import android.os.AsyncTask;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MakeRequestTask extends AsyncTask {

    private Sheets mService;

    MakeRequestTask(){
        mService = new Sheets()
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }



    void putDataFromApi() throws IOException {
        String spreadsheetId = "S1Zt5Yyq-vkirbHFR5a4YVMI9CgN-CNorFGCrZmc8-A";
        String range = "シート1!A2:D2";
        ValueRange valueRange = new ValueRange();
        List row = new ArrayList<>();
        List col = Arrays.asList("This", "is", "test", "test");
        row.add(col);
        valueRange.setValues(row);
        valueRange.setRange(range);
        this.mService.spreadsheets().values()
                .update(spreadsheetId, range, valueRange)
                .setValueInputOption("USER_ENTERED")
                .execute();
    }
}
