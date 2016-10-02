package com.example.utkarshsingh.assign3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {

            }
        }
    }
    public void button(View view) {
        Intent i = new Intent(this,SharedActivity.class);
        startActivityForResult(i, 1);
    }

    public void writedata(String data) {
        //BufferedWriter out = null;
        Log.d("ss", "writedata: ");
        System.out.println(data);
        /*try{

            File myFile = new File("/sdcard/mysdfile.txt");
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter =
                    new OutputStreamWriter(fOut);
            myOutWriter.append(data);
            myOutWriter.close();
            fOut.close();


        } catch (Exception e) {
            System.out.println("CCCCCCCCCCCCCCCCCCCCCCCALSKDJLAK");
        }*/

            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("config.txt", Context.MODE_PRIVATE));
                outputStreamWriter.write(data);
                outputStreamWriter.close();
            }
            catch (IOException e) {
                Log.e("Exception", "File write failed: " + e.toString());
            }


    }

    public void button2(View view) {
        Intent i2 = new Intent(this,FileActivity.class);
        startActivityForResult(i2, 1);
        //writedata("Yashimitsu");
    }

    public void readdata()
    {
        /*try {
            File myFile = new File("/sdcard/mysdfile.txt");
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(
                    new InputStreamReader(fIn));
            String aDataRow = "";
            String aBuffer = "";
            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer += aDataRow + "\n";
            }
            System.out.println(aBuffer);
            myReader.close();
        } catch (Exception e) {
        }*/
        String ret = "";

        try {
            InputStream inputStream = this.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        System.out.println(ret+"YOUr");
    }

    public void button3(View view) {
        Intent i3 = new Intent(this,DataActivity.class);
        startActivityForResult(i3,1);
    }


}