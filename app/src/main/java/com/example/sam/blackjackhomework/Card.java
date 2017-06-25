package com.example.sam.blackjackhomework;

/**
 * Created by Sam on 23/06/2017.
 */

public class Card {
    private String suit;
    private String name;
    private int value;

    public Card(String suit, String name, int value){
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public String viewCard(){
        return getName() + " of " + getSuit();
    }


}