package com.example.cricbuzz.Model;

public class tossResults {

    private int tossWinnerId;
    private String tossWinnerName;
    private String decision;

    public int getTossWinnerId() {
        return tossWinnerId;
    }

    public void setTossWinnerId(int tossWinnerId) {
        this.tossWinnerId = tossWinnerId;
    }

    public String getTossWinnerName() {
        return tossWinnerName;
    }

    public void setTossWinnerName(String tossWinnerName) {
        this.tossWinnerName = tossWinnerName;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }
}
