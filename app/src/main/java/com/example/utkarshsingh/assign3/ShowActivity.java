package com.example.utkarshsingh.assign3;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity {
    EditText roll;
    EditText r1;
    EditText r2;
    EditText r3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        roll= (EditText) findViewById(R.id.editText1);
        r1= (EditText) findViewById(R.id.editText5);
        r2= (EditText) findViewById(R.id.editText6);
        r3= (EditText) findViewById(R.id.editText7);
        r1.setText("Roll No. : ");
        r2.setText("Name : ");
        r3.setText("Semester : ");
    }

    public void showentry(View view)
    {
        r1.setText("Roll No. : ");
        r2.setText("Name : ");
        r3.setText("Semester : ");
        String rollno = roll.getText().toString();
        Cursor a=DataActivity.my.getData(rollno);
        if(a.getCount()>0)
        {
            while(a.moveToNext())
            {
                r1.setText("Roll No. : " + a.getString(0));
                r2.setText("Name : " + a.getString(1));
                r3.setText("Semester : " + a.getString(2));
            }
        }
        else
        {
            Toast.makeText(this, "Entry Not found!!! ",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
