package com.app.golftwosview;

public class Player {
    // fields
    private int playerID;
    private String playerName;
    private double amount;
    private String date;

    // constructors
    public Player() {
    }

    public Player(int id, String playerName, double amount, String date) {
        this.playerID = id;
        this.playerName = playerName;
        this.amount = amount;
        this.date = date;

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

    public void setAmount( double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

}