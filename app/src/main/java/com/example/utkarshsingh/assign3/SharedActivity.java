package com.example.utkarshsingh.assign3;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class SharedActivity extends AppCompatActivity {
    String s1="";
    String s2="";
    //SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
    //SharedPreferences.Editor editor = sharedPref.edit();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);

        TextView e1 = (TextView) findViewById(R.id.Text1);
        s1 = e1.getText().toString();
        TextView e2 = (TextView) findViewById(R.id.Text2);
        s2 = e2.getText().toString();
    }

    public void check(View view)
    {
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        Map<String, ?> allEntries = sharedPref.getAll();
        TextView e1 = (TextView) findViewById(R.id.Text1);
        String ss=e1.getText().toString();
        if (ss.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            int f = 0;
            for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                //Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
                //TextView tt= new TextView(this);
                if (entry.getKey().equals(ss)) {
                    //toast;
                    TextView e2 = (TextView) findViewById(R.id.Text2);
                    e2.setText(entry.getValue().toString());
                    Toast.makeText(this, "Yes the username already exists!!!",
                            Toast.LENGTH_SHORT).show();
                    f = 1;
                    break;
                }
            }
            if (f == 0)
                Toast.makeText(this, "Oops there is no such username.",
                        Toast.LENGTH_SHORT).show();
        }
    }

    public void save(View view) {
       /* Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);*/

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        TextView e1 = (TextView) findViewById(R.id.Text1);
        s1=e1.getText().toString();
        if (s1.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            TextView e2 = (TextView) findViewById(R.id.Text2);
            s2 = e2.getText().toString();
            e1.setText("");
            e2.setText("");
            e1.setHint("Username");
            e2.setHint("Password");
        /*TextView e1 = (TextView) findViewById(R.id.Text1);
        String s1 = e1.getText().toString();
        TextView e2 = (TextView) findViewById(R.id.Text2);
        String s2 = e2.getText().toString();
        e2.setText(s1);*/
            editor.putString(s1, s2);
            editor.commit();
            //Log.d(s1, "S1 ");
            Toast.makeText(this, "Username and Password saved successfully",
                    Toast.LENGTH_LONG).show();
        }
    }
int k=0;
    public void show(View view){
        //Intent i2 = new Intent(this,Shared2Activity.class);
        //startActivityForResult(i2, 1);
        Toast.makeText(this, "Here comes your list!!!)",
                Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        LinearLayout list = (LinearLayout) findViewById(R.id.table);
        list.removeAllViews();
       //String highScore = sharedPref.getString(s2, null);
        Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
            TextView tt= new TextView(this);
            tt.setText(entry.getKey() + " : " + entry.getValue().toString());
            list.addView(tt);
        }
        //TextView e2 = (TextView) findViewById(R.id.Text2);
        //Log.d("aajak", highScore);
        //e2.setText(highScore);

    }
}