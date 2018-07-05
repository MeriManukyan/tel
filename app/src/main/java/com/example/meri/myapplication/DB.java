package com.example.meri.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB {
    private String id="_id";
    private String dbname="dbc";
    public static final String name="name";
    public static final String phone="phone";
    private String dv="data3";
    private MSQL msql;
    private  SQLiteDatabase sqd;
    private Context ctx;

    public DB(Context ctx) {
        this.ctx = ctx;
    }
    public Cursor getAllData() {
        return sqd.query(dbname, null, null, null,
                null, null, null);
    }

    public void open() {

        msql=new MSQL(ctx,dv,null,1);
        sqd=msql.getWritableDatabase();

    }
    public void add(String t,String s){
        ContentValues cv = new ContentValues();
        cv.put(name, t);
        cv.put(phone, s);
        sqd.insert(dbname, null, cv);
    }

    class MSQL extends SQLiteOpenHelper{

        public MSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }




        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(    "create table " + dbname + "(" +
                    id + " integer primary key autoincrement, " +
                    name + " text, " +
                    phone + " text," +
                    "unique (name,phone)"+
                    ");");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
