package com.app.golftwosview;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper {
    //information of database
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "playerDB.db";
    public static final String TABLE_NAME = "Player";
    public static final String COLUMN_ID = "PlayerID";
    public static final String COLUMN_NAME = "playerName";
    public static final String COLUMN_BAL = "balance";
    public static final String COLUMN_BAL_DATE = "balanceDate";
    public static final String COLUMN_TWOS_AMOUNT = "twosAmount";
    public static final String COLUMN_TWOS_DATE = "twosDate";


    //initialize the database
    public MyDBHandler() {
        super(DATABASE_NAME, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    //@Override
    /*//public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "(" + COLUMN_ID +
                "INTEGER PRIMARYKEY," + COLUMN_NAME + "TEXT + COLUMN_BAL +
    */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    //public String loadHandler() {}
    public void addHandler(Player player) {
    }

    public Player findHandler(String StringPlayerName) {

        String query = "Select * FROM " + TABLE_NAME + "WHERE" + COLUMN_NAME + " = " + "'" + playerName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Player player = new Player();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            player.setID(Integer.parseInt(cursor.getString(0)));
            player.setplayerName(cursor.getString(1));
            cursor.close();
        } else {
            player = null;
        }
        db.close();
        return player;

    }
    //public boolean deleteHandler(int ID) {}

    public boolean updateHandler(int ID, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(COLUMN_ID, ID);
        args.put(COLUMN_NAME, name);
        return db.update(TABLE_NAME, args, COLUMN_ID + "=" + ID, null) > 0;

    }
    //findplayer method
    public void findStudent(View view) {
        MyDBHandler player = dbHandler.findHandler(playerName.getText().toString());
        if (player != null) {
            lst.setText(String.valueOf(player.getID()) + " " + player.getStudentName() + System.getProperty("line.separator"));
            playerid.setText("");
            playerName.setText("");
        } else {
            lst.setText("No Match Found");
            playerid.setText("");
            playerName.setText("");
        }
    }
    //update player method.
    public void updateStudent(View view) {
        MyDBHandler dbHandler = new MyDBHandler();
        boolean result = dbHandler.updateHandler(Integer.parseInt(
                playerid.getText().toString()), playerName.getText().toString());
        if (result) {
            playerid.setText("");
            playerName.setText("");
            lst.setText("Record Updated");
        } else
            playerid.setText("No Match Found");
    }
}
