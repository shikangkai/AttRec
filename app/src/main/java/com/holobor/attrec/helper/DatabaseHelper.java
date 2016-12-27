package com.holobor.attrec.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Holobor on 2016/5/29.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
         * ID
         * ATT_START
         * ATT_END
         * DAY_STAMP
         */
        db.execSQL("CREATE TABLE tATT (ID INTEGER PRIMARY KEY AUTOINCREMENT, ATT_START INTEGER, ATT_END INTEGER, DAY_STAMP INTEGER);");
        /**
         * ID
         * TIME
         * DAY_STAMP
         * DIARY
         * TAG
         */
        db.execSQL("CREATE TABLE tDIARY (ID INTEGER PRIMARY KEY AUTOINCREMENT, TIME INTEGER, DAY_STAMP INTEGER, DIARY TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
