package com.example.sam.blackjackhomework;

import com.example.sam.blackjackhomework.Enum.Suit;
import com.example.sam.blackjackhomework.Enum.Value;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sam on 25/06/2017.
 */

public class TestCard {
    Card card;

    @Before
    public void before(){
        card = new Card(Suit.SPADES.toString(), Value.ACE.toString(), Value.ACE.getValue());
    }

    @Test
    public void testGetName(){
        assertEquals("ACE", card.getName());
    }

    @Test
    public void testGetSuit(){
        assertEquals("SPADES", card.getSuit());
    }

    @Test
    public void testGetValue(){
        assertEquals(11, card.getValue());
    }

    @Test
    public void testSetValue(){
        card.setValue(1);
        assertEquals(1, card.getValue());
    }

    @Test
    public void testViewCard(){
        assertEquals("ACE of SPADES", card.viewCard());
    }
}
