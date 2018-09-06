package com.app.golftwosview;

public class Player {
    // fields
    private int playerID;
    private String playerName;

    // constructors
    public Player() {
    }

    public Player(int id, String playerName) {
        this.playerID = id;
        this.playerName = playerName;


    }
    // properties
    public void setID(int id) {
        this.playerID = id;
    }

    public int getID() {
        return this.playerID;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }
}