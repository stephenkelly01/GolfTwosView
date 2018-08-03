package com.app.golftwosview;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;


public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "playerDB.db";
    public static final String TABLE_NAME = "Player";
    public static final String COLUMN_ID = "PlayerID";
    public static final String COLUMN_NAME = "PlayerName";

    //initialize the database
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + COLUMN_ID +
                "INTEGER PRIMARYKEY," + COLUMN_NAME + "TEXT )";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public void addHandler(Player player) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, player.getID());
        values.put(COLUMN_NAME, player.getPlayerName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Player findHandler(String PlayerName) {

        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_NAME + "EQUALS" + "'" + PlayerName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Player player = new Player();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            player.setID(Integer.parseInt(cursor.getString(0)));
            player.setPlayerName (cursor.getString(1));
            cursor.close();
        } else {
            player = null;
        }
        db.close();
        return player;

    }

    public boolean updateHandler(int ID, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, name);
        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null) > 0;

    }

}
