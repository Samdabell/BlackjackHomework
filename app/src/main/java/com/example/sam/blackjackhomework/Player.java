package com.example.sam.blackjackhomework;

import java.util.ArrayList;

import static com.example.sam.blackjackhomework.Enum.Value.ACE;

/**
 * Created by Sam on 23/06/2017.
 */

public class Player {

    private String name;
    private ArrayList<Card> cards;

    public Player(String name){
        this.name = name;
        this.cards = new ArrayList<Card>();
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Card> getCards(){
        return this.cards;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public int sumCards(){
        int total = 0;
        for(Card card : cards){
            total += card.getValue();
        }
        return total;
    }

    public void aceCheck(){
        if (sumCards() > 21){
            for (Card card : getCards()){
                if (card.getValue() == 11){
                    card.setValue(1);
                    break;
                }
            }
        }
    }

    public boolean bustCheck(){
       return sumCards() > 21;
    }
}
