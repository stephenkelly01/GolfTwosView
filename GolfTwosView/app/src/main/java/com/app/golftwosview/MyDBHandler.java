package com.app.golftwosview;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;

import java.util.Date;


public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "playerDB.db";
    public static final String TABLE_NAME = "Player";
    public static final String COLUMN_ID = "PlayerID";
    public static final String COLUMN_NAME = "PlayerName";
    public static final String COLUMN_AMOUNT = "0.00";
    private static final String COLUMN_DATE = "ddMMyyy";
    /* initialize the database */
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + COLUMN_ID +
                "INTEGER PRIMARYKEY," + COLUMN_NAME + "TEXT + COLUMN_AMOUNT + amount + COLUMN_DATE + date )";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public void addHandler(Player player) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, player.getID());
        values.put(COLUMN_NAME, player.getPlayerName());
        values.put(COLUMN_AMOUNT, player.getAmount());
        values.put(COLUMN_DATE, player.getDate());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public boolean updateHandler(int ID, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, name);
        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null) > 0;

    }

}
