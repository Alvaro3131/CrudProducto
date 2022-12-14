package com.example.crudproducto;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseHelper extends SQLiteOpenHelper {
    String tabla="CREATE TABLE PRODUCTOS(ID INTEGER PRIMARY KEY AUTOINCREMENT,Nombre TEXT, Stock INTEGER, Precio REAL)";
    public BaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabla);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table PRODUCTOS");
        db.execSQL(tabla);
    }
}
