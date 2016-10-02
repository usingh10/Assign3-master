package com.example.utkarshsingh.assign3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    EditText roll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        roll= (EditText) findViewById(R.id.editText1);
    }

    public void delete2(View view)
    {
        String rollno = roll.getText().toString();
        Integer a=DataActivity.my.deleteContact(rollno);
        roll.setText("");
        if(a!=0)
            Toast.makeText(this, "Given Entry Deleted!!! ", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Given Entry Not found!!! ", Toast.LENGTH_SHORT).show();
    }

    public void deleteall(View view)
    {
        DataActivity.my.deleteContacts();
        roll.setText("");
        Toast.makeText(this, "All Entries Deleted!!! ",
                Toast.LENGTH_SHORT).show();
    }
}
