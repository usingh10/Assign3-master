package com.example.utkarshsingh.assign3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        //checkExternalMedia();
        //writeToSDFile();
        //readRaw();
    }

    public void fileread(View view) {
        String data = "";

        try {
            InputStream inputStream = this.openFileInput("config.txt");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                data = stringBuilder.toString();
            }
            Toast.makeText(this, "Text successfully retrieved from Internal Storage... ", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
            Toast.makeText(this, "File not found... ", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
            Toast.makeText(this, "Cannot read file... ", Toast.LENGTH_SHORT).show();
        }
        EditText e1 = (EditText) findViewById(R.id.Filetext);
        e1.setText(data);
        System.out.println(data + "Go");
    }

    public void filewrite(View view) {
        EditText e1 = (EditText) findViewById(R.id.Filetext);
        String data = e1.getText().toString();
        e1.setText("");
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            Toast.makeText(this, "Text successfully saved to Internal Storage... ", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
            Toast.makeText(this, "File write failed... ", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    private String filename = "SampleFile.txt";
    private String filepath = "MyFileStorage";
    File myExternalFile;
    String myData = "";

    private static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    public void extread(View view) {
        myData="";
        Button fileextread = (Button) findViewById(R.id.getExternalStorage);
        Button fileextwrite = (Button) findViewById(R.id.saveExternalStorage);
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            fileextread.setEnabled(false);
            fileextwrite.setEnabled(false);
            Toast.makeText(this, "No External Storage!!! ", Toast.LENGTH_SHORT).show();
            System.out.println("NO Ext Storage");
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }
        EditText e1 = (EditText) findViewById(R.id.Filetext);
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
            Toast.makeText(this, "Data successfully retrieved from External Storage(Private)... ", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        e1.setText(myData);
        System.out.println("SampleFile.txt data retrieved from External Storage...");
    }

    public void extwrite(View view) {
        Button fileextread = (Button) findViewById(R.id.getExternalStorage);
        Button fileextwrite = (Button) findViewById(R.id.saveExternalStorage);
        Log.d("1", "extwrite: ");
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            fileextread.setEnabled(false);
            fileextwrite.setEnabled(false);
            Toast.makeText(this, "No External Storage!!! ", Toast.LENGTH_SHORT).show();
            System.out.println("NO Ext Storage");
        }
        else {
            myExternalFile = new File(getExternalFilesDir(filepath), filename);
        }
        Log.d("2", "extwrite: ");
        EditText e1 = (EditText) findViewById(R.id.Filetext);
        try {
            FileOutputStream fos = new FileOutputStream(myExternalFile);
            fos.write(e1.getText().toString().getBytes());
            fos.close();
            Toast.makeText(this, "Text successfully saved to External Storage(Private)... ", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("3", "extwrite: ");
        e1.setText("");
        //System.out.println("SampleFile.txt saved to External Storage...");
    }

    public void pubread(View view)
    {
        myData="";
        Toast.makeText(getApplicationContext(),"aaaya",Toast.LENGTH_SHORT).show();
        Button fileextread = (Button) findViewById(R.id.getPublicStorage);
        Button fileextwrite = (Button) findViewById(R.id.savePublicStorage);
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            fileextread.setEnabled(false);
            fileextwrite.setEnabled(false);
            System.out.println("NO Ext Storage");
        }
        else {
            myExternalFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),filename);
        }
        EditText e1 = (EditText) findViewById(R.id.Filetext);
        try {
            FileInputStream fis = new FileInputStream(myExternalFile);
            DataInputStream in = new DataInputStream(fis);
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                myData = myData + strLine;
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        e1.setText(myData);
        System.out.println("SampleFile.txt data retrieved from Internal Storage...");
    }

    public void pubwrite(View view)
    {
        Button fileextread = (Button) findViewById(R.id.getPublicStorage);
        Button fileextwrite = (Button) findViewById(R.id.savePublicStorage);
        Log.d("1", "extwrite: ");
        File folder;
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            fileextread.setEnabled(false);
            fileextwrite.setEnabled(false);
            System.out.println("NO Ext Storage");
        }
        else {
            myExternalFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),filename);
            //boolean isPresent = true;
            //if(!folder.exists())
              //  folder.mkdirs();
            /*if (!folder.exists()) {
                isPresent = folder.mkdir();
            }
            if (isPresent) {
                myExternalFile = new File(folder.getAbsolutePath(),filename);
            }*/
            //myExternalFile = new File(folder.getAbsolutePath(),filename);
        }

        Log.d("2", "extwrite: ");
        EditText e1 = (EditText) findViewById(R.id.Filetext);
        try {
            FileOutputStream fos = new FileOutputStream(myExternalFile);
            fos.write(e1.getText().toString().getBytes());
            fos.close();
            System.out.println("Written");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("3", "extwrite: ");
        e1.setText("");
        System.out.println("SampleFile.txt saved to External Storage...");

    }
}
