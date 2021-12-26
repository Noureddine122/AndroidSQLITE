package com.example.sqllite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.List;

class MyDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_TABLE_NAME = "mydb2";
    private static final String PKEY = "pkey";
    private static final String COL1 = "col1";
    private static final String COL2 = "col2";

    MyDatabase(Context context) {
        super(context, DATABASE_TABLE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String DATABASE_TABLE_CREATE = "CREATE TABLE " + DATABASE_TABLE_NAME + " (" +
                PKEY + " INTEGER PRIMARY KEY," +
                COL1 + " TEXT,"+ COL2+" TEXT);";
        db.execSQL(DATABASE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(String s, String ss) {
        Log.d("JFL", " Insert in database");
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(COL1, s);
        values.put(COL2, ss);
        db.insertOrThrow(DATABASE_TABLE_NAME, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
    }
    @SuppressLint("Range")
    public void readData(ArrayAdapter<String> r, List<String> ls)
    {

        int c =0;


        Log.i("JFL", "Reading database...");
        String select = new String("SELECT * from " + DATABASE_TABLE_NAME);
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(select, null);
        Log.i("JFL", "Number of entries: " + cursor.getCount());
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                ls.add("N° : " +c+ ":: Nom :" + cursor.getString(cursor.getColumnIndex(COL1)) + " ||| Prenom: "+ cursor.getString(cursor.getColumnIndex(COL2)) + ".");
                r.notifyDataSetChanged();

                Log.i("JFL", "Reading: " +c+ " :: " + cursor.getString(cursor.getColumnIndex(COL1)) + cursor.getString(cursor.getColumnIndex(COL2)));
                c++;
            } while (cursor.moveToNext());
        }
    }
    public void deleteAll()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from "+ DATABASE_TABLE_NAME);
        db.close();
    }
}