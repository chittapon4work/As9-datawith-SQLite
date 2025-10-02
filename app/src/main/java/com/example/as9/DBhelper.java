package com.example.as9;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper{

    public static final String DB_name =  "dbstudents.db";
    public static final String table_name =  "student_table";

    public DBhelper(Context context){
        super(context,DB_name,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE "+table_name+
                "(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "first_name TEXT,"+
                "last_name TEXT,"+
                "age INTEGER,"+
                "tel TEXT,"+
                "email TEXT,"+
                "fac TEXT)";
        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_STUDENT_TABLE = "DROP TABLE IF EXISTS "+table_name;
        db.execSQL(DROP_STUDENT_TABLE);
        onCreate(db);
    }
    public Cursor getStudent(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+table_name,null);
    }
}
