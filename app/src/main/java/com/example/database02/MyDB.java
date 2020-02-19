package com.example.database02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDB {

    private DatabaseHelper dbHelper;

    private SQLiteDatabase database;

    public final static String Categoria3 ="Categoria3"; // name of table

    public final static String _id = "_id"; // id value for employee
    public final static String Nombres = "Nombres";  // name of employee

    /**
     *
     * @param context
     */
    public MyDB(Context context){
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }


    public long createRecords(String id, String name){
        ContentValues values = new ContentValues();
        values.put(_id, id);
        values.put(Nombres, name);
        return database.insert(Categoria3, null, values);
    }

    public Cursor selectRecords(String columnas, String tabla,String where) {
        String[] cols = new String[] {_id, Nombres};
        Cursor mCursor = database.rawQuery("SELECT " + columnas + " FROM " + tabla +" "+ where + ";",null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor; // iterate to get each value.
    }
}
