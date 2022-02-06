package com.example.rollcount2;

import java.io.Serializable;

public class Game implements Serializable {
    private String gameName;
    private String dicePerRoll;
    private String sidesPerDie;

    Game(String gameName, String dicePerRoll, String sidesPerDie) {
        this.gameName = gameName;
        this.dicePerRoll = dicePerRoll;
        this.sidesPerDie = sidesPerDie;
    }

    public String getGameName() {
        return this.gameName;
    }

    public String getDicePerRoll() {
        return this.dicePerRoll;
    }

    public String getSidesPerDie() {
        return this.sidesPerDie;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setDicePerRoll(String dicePerRoll) {
        this.dicePerRoll = dicePerRoll;
    }

    public void setSidesPerDie(String sidesPerDie) {
        this.sidesPerDie = sidesPerDie;
    }
}