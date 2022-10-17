package com.example.inventoryandroid_10;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {

    // Aqui se puede anotar la tabla
    String tabla="CREATE TABLE PERSONAS(ID INTEGER PRIMARY KEY, NOMBRE TEXT, APELLIDO TEXT)";
    public BaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table personas");
        db.execSQL(tabla);

    }
}
