package com.app.golftwosview;

import com.javahelps.externalsqliteimporter.*;
import com.javahelps.importexternaldatabase.*;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
//import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.Date;
import java.io.File;
import java.util.List;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private int textID ;
    private  String textName;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE };
    private final boolean fromExternalSource = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Request for permission to read external storage
        if (fromExternalSource && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        } else {
            showQuotes();
        }
    }

    private void showQuotes() {
        DatabaseAccess databaseAccess;
        if (fromExternalSource) {
            // Check the external database file. External database must be available for the first time deployment.
            String externalDirectory = Environment.getExternalStorageDirectory().getAbsolutePath() + "/database";
            File dbFile = new File(externalDirectory, DatabaseOpenHelper.DATABASE_NAME);
            if (!dbFile.exists()) {
                return;
            }
            // If external database is avaliable, deploy it
            databaseAccess = DatabaseAccess.getInstance(this, externalDirectory);
        } else {
            // From assets
            databaseAccess = DatabaseAccess.getInstance(this, null);
        }

        databaseAccess.open();
        List<String> quotes = databaseAccess.getQuotes();
        databaseAccess.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, quotes);
        //this.textID.setAdapter(adapter);
    }

    public void updatePlayer(View view) {
        System.out.print("match found");

    }

    public void findPlayer(View view) {

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Player player = null;
        player = dbHandler.findHandler(player.getPlayerName());
        if ( player != null) {
            R.id.setText(String.valueOf(player.getID()) + " " + player.getPlayerName() + System.getProperty("line.separator"));
            R.id.playername.setText("");
            R.id.setText("");
       } else {

            R.id.lst.setText("No Match Found");
            R.id.lst.playerID.setText("");
            R.id.lst.setText("");
        }

    }
    public void addPlayer(View view) {

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        textID = R.id.playerid;
        textName =  String.valueOf(R.id.playername);
        textAmount = R.id.playeramount;
        textDate = String.valueOf(R.id.playerdate);
        Player player = new Player();
        dbHandler.addHandler(player);
    }
}
