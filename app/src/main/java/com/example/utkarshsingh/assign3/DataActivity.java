package com.example.utkarshsingh.assign3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DataActivity extends AppCompatActivity
{
    public static DataBaseHelper my;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        my=new DataBaseHelper(this);
    }

    public void add(View view)
    {
        Intent d1 = new Intent(this,AddActivity.class);
        startActivityForResult(d1,1);
    }

    public void update(View view)
    {
        Intent d2 = new Intent(this,UpdateActivity.class);
        startActivityForResult(d2,1);
    }

    public void delete(View view)
    {
        Intent d3 = new Intent(this,DeleteActivity.class);
        startActivityForResult(d3,1);
    }

    public void show(View view)
    {
        Intent d4 = new Intent(this,ShowActivity.class);
        startActivityForResult(d4,1);
    }

    public void showall(View view)
    {
        Intent d5 = new Intent(this,ShowallActivity.class);
        startActivityForResult(d5,1);
    }
}
