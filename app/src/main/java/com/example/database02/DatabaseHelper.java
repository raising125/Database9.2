package com.example.database02;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "starDatabase";

    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table Categoria3( _id integer primary key, Nombres text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
        database.execSQL("INSERT INTO Categoria3 VALUES(1,'Hello World1')");
        database.execSQL("INSERT INTO Categoria3 VALUES(2,'Hello World2')");
        database.execSQL("INSERT INTO Categoria3 VALUES(3,'Hello World3')");
        database.execSQL("INSERT INTO Categoria3 VALUES(4,'Hello World4')");
        database.execSQL("INSERT INTO Categoria3 VALUES(5,'Hello World5')");
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database,int oldVersion,int newVersion){
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS MyEmployees");
        onCreate(database);
    }
}
