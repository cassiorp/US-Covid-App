package com.example.uscovidapp.States;

public class StatesModel {
    private String state;
    private String positive;
    private String death;

    public StatesModel(String state, String positive, String death) {
        this.state = state;
        this.positive = positive;
        this.death = death;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }
}
