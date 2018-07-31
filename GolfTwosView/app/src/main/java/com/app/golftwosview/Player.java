package com.app.golftwosview;

public class Player {
    // fields
    private int playerID;
    private String playerName;
    private float balance;
    private String balanceDate;
    private String twosDate;
    private float twosAmount;

    // constructors
    public Player() {
    }

    public Player(int id, String playerName, float balance, String balanceDate, String twosDate, float towsAmount) {
        this.playerID = id;
        this.playerName = playerName;
        this.balance = balance;
        this.balanceDate = balanceDate;
        this.twosAmount = towsAmount;
        this.twosDate = twosDate;
    }

    // properties
    public void setID(int id) {
        this.playerID = id;
    }

    public int getID() {
        return this.playerID;
    }

    public void setplayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return this.playerName;
    }
}