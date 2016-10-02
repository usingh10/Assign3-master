package com.example.utkarshsingh.assign3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText roll;
    EditText name;
    EditText semester;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        roll= (EditText) findViewById(R.id.editText1);
        name= (EditText) findViewById(R.id.editText2);
        semester= (EditText) findViewById(R.id.editText3);
    }

    public void updateentry(View view)
    {
        String rollno = roll.getText().toString();
        String nam = name.getText().toString();
        String sem = semester.getText().toString();
        boolean x=DataActivity.my.updateContact(rollno,nam,sem);
        roll.setText("");
        name.setText("");
        semester.setText("");
        if(x==false)
        {
            Toast.makeText(this, "Entry Not Found!!! ",
                    Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Entry successfully updated!!! ",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
