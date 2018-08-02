package com.app.golftwosview;

import android.app.ActionBar;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void updatePlayer(View view)
    {
        MyDBHandler dbHandler = new MyDBHandler(null, null, null, 1);
        boolean result;

        if (dbHandler.updateHandler(Integer.parseInt(
                playerid.getText().toString()), playername.getText().toString())) result = true;
        else result = false;
        if (result) {
            playerid.setText("");
            playername.setText("");
            lst.setText("Record Updated");
        } else {
            playerid.setText("No Match Found");
        }
    }
    public void findPlayer(View view) {
        MyDBHandler dbHandler = new MyDBHandler(null, null, null, 1);
        Player player =
                dbHandler.findHandler(playername.getText().toString());
        if (playername != null) {
            lst.setText(String.valueOf(player.getID()) +  " " + player.getPlayerName() + System.getProperty("line.separator"));
            playerid.setText("");
            playername.setText("");
        } else {
            lst.setText("No Match Found");
            playerid.setText("");
            playername.setText("");
        }
    }
}
