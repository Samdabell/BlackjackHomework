package com.example.sam.blackjackhomework.Enum;

/**
 * Created by Sam on 25/06/2017.
 */

public enum Choice {

    HIT("Hit"),
    STICK("Stick");

    public String choice;

    Choice(String choice){
        this.choice = choice;
    }

    public String getChoice(){
        return this.choice;
    }

}
