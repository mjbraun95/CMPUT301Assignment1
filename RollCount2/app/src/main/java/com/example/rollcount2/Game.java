package com.example.rollcount2;

import java.io.Serializable;
import java.sql.Date;

public class Game implements Serializable {
//    private String id;
    private String gameName;
    private String dicePerRoll;
    private String sidesPerDie;
    private String numberOfRolls;
    private String dateStarted;

    Game(String gameName, String dicePerRoll, String sidesPerDie, String numberOfRolls, String dateStarted) {
//        this.id = id;
        this.gameName = gameName;
        this.dicePerRoll = dicePerRoll;
        this.sidesPerDie = sidesPerDie;
        this.numberOfRolls = numberOfRolls;
        this.dateStarted = dateStarted;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getDicePerRoll() {
        return this.dicePerRoll;
    }

    public String getSidesPerDie() { return this.sidesPerDie; }

    public String getNumberOfRolls() { return this.numberOfRolls; }

    public String getDateStarted() { return this.dateStarted; }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setDicePerRoll(String dicePerRoll) {
        this.dicePerRoll = dicePerRoll;
    }

    public void setSidesPerDie(String sidesPerDie) {
        this.sidesPerDie = sidesPerDie;
    }

    public void setNumberOfRolls(String numberOfRolls) {
        this.numberOfRolls = numberOfRolls;
    }

    public void getDateStarted(String dateStarted) { this.dateStarted = dateStarted; }
}
