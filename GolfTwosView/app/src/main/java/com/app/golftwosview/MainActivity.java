package com.app.golftwosview;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void updatePlayer(View view) {
        System.out.print("match found");

    }

    public void findPlayer(View view) {

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Player player =
                dbHandler.findHandler(String.valueOf(R.id.lst));
        if ( player != null) {
            System.out.print("match found");

        } else {System.out.print("match not found");}
    }
    public void addPlayer(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int id = R.id.lst;
        int names = R.id.btnAdd;
        String name = String.valueOf(names);
        Player player = new Player(id, name);
        dbHandler.addHandler(player);

    }
}
