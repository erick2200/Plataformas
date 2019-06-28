package com.example.agendadeclientes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminDataBase extends SQLiteOpenHelper {
    public AdminDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Database) {

        String sql = "CREATE TABLE IF NOT EXISTS CLIENTE (NOMBRE VARCHAR(40)," +
                     "DIRECCION VARCHAR(256), EMAIL VARCHAR(126), TELEFONO VARCHAR(12))";
        Database.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
