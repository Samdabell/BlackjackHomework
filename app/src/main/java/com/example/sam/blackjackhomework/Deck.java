package com.example.sam.blackjackhomework;

import com.example.sam.blackjackhomework.Enum.Suit;
import com.example.sam.blackjackhomework.Enum.Value;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sam on 23/06/2017.
 */

public class Deck {
     private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();
    }

    private void addCard(Card card){
        cards.add(card);
    }

    public void makeDeck(){
        Suit[] suits = Suit.values();
        Value[] values = Value.values();

        for(Suit suit : suits){
            for(Value value : values){
                Card newCard= new Card(suit.getSuit(), value.getName(), value.getValue());
                addCard(newCard);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    private void removeFromDeckByIndex(int index) {
        cards.remove(index);
    }

    public Card drawCard(){
        Card drawnCard= cards.get(0);
        removeFromDeckByIndex(0);
        return drawnCard;
    }

    public int countCards(){
        return cards.size();
    }

}
