package com.app.golftwosview;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;


public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lisheen.db";
    private static final String TABLE_NAME = "Player";
    private static final int  COLUMN_ID = 0;
    private static final String COLUMN_NAME = "PlayerName";

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
        values.put(COLUMN_NAME, player.getPlayerName());
        values.put(COLUMN_ID, player.getID());


        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public boolean updateHandler(int ID, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_NAME, COLUMN_ID);
        args.put(COLUMN_NAME, name);
        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null) > 0;

    }
    public Player findHandler(String playername) {
        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_NAME + " = " + "'" + playername + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Player player = new Player();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            player.setID(Integer.parseInt(cursor.getString(0)));
            player.setPlayerName(cursor.getString(1));
            cursor.close();
        } else {
            player = null;
        }
        db.close();
        return player;
    }

}
