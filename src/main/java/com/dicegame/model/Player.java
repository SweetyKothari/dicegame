package com.dicegame.model;

/**
 * This stores player information
 */
public class Player {
    String name;
    int totalScore;
    int previousScore;
    int rank;
    boolean skipNext;

    public  Player(String playerName){
        this.name=playerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getPreviousScore() {
        return previousScore;
    }

    public void setPreviousScore(int previousScore) {
        this.previousScore = previousScore;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public boolean isSkipNext() {
        return skipNext;
    }

    public void setSkipNext(boolean skipNext) {
        this.skipNext = skipNext;
    }
}
