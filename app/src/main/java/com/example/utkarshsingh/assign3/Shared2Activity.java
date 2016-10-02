package com.example.utkarshsingh.assign3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Map;

public class Shared2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared2);
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        //String highScore = sharedPref.getString(s2, null);
        Log.d("map values","P");
        LinearLayout list = (LinearLayout) findViewById(R.id.table);
        TextView t= new TextView(this);
        t.setText("My name is");
        list.addView(t);
        //Map<String,?> allEntries = sharedPref.getAll();
        Map<String, ?> allEntries = sharedPref.getAll();
        /*for (Object entry : allEntries.keySet()) {
            Log.d("map values", entry.toString() + ": " + allEntries.get(entry).toString());
            TextView tt= new TextView(getApplicationContext());
            tt.setText(entry.toString() + " : " + allEntries.get(entry).toString());
            list.addView(tt);
        }*/
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            TextView tt= new TextView(getApplicationContext());
            tt.setText(entry.getKey() + " : " + entry.getValue().toString());
            list.addView(tt);
        }
    }
}
