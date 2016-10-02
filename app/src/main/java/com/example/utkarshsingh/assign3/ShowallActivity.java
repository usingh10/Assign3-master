package com.example.utkarshsingh.assign3;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowallActivity extends AppCompatActivity {
    TextView all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showall);
        Cursor a=DataActivity.my.showData();
        all = (TextView) findViewById(R.id.editText4);
        if(a.getCount()>0)
        {
            while(a.moveToNext())
            {
                all.append("Roll No. : " + a.getString(0) + "  Name : " + a.getString(1) + "  Sem : " + a.getString(2) + "\n");
            }
        }

    }
}
