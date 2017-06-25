package com.example.sam.blackjackhomework.Enum;

/**
 * Created by Sam on 23/06/2017.
 */

public enum Suit {

    SPADES("Spades"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts");

    private String suit;

    Suit(String suit){
        this.suit = suit;
    }

    public String getSuit(){
        return this.suit;
    }
}
