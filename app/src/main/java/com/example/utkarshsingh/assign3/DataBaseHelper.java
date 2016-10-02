package com.example.utkarshsingh.assign3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Utkarsh Singh on 02-10-2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String CONTACTS_TABLE_NAME = "students";
    public static final String CONTACTS_COLUMN_1 = "rollno";
    public static final String CONTACTS_COLUMN_2 = "name";
    public static final String CONTACTS_COLUMN_3 = "semester";

    public DataBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + CONTACTS_TABLE_NAME + "(rollno integer primary key,name,semester)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public boolean insertContact (String a1, String a2, String a3)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rollno", a1);
        contentValues.put("name", a2);
        contentValues.put("semester", a3);
        long x=db.insert(CONTACTS_TABLE_NAME, null, contentValues);
        if(x==-1)
            return false;
        return true;
    }

    public Cursor getData(String id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from students where rollno=" + id + "", null);
        return res;
    }

    public Cursor showData()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from students", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateContact ( String rollno, String name, String semester)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("rollno", rollno);
        contentValues.put("name", name);
        contentValues.put("semester", semester);
        db.update("students", contentValues, "rollno = ? ", new String[] { rollno } );
        return true;
    }

    public Integer deleteContact (String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("students", "rollno = ? ", new String[] { id });
    }

    public void deleteContacts ()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("Delete from students");
    }


}
