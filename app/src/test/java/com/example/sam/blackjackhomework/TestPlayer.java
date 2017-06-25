package com.example.sam.blackjackhomework;

import com.example.sam.blackjackhomework.Enum.Suit;
import com.example.sam.blackjackhomework.Enum.Value;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sam on 25/06/2017.
 */

public class TestPlayer {

    Player player;
    Card card1;
    Card card2;
    Card card3;
    Card card4;

    @Before
    public void before(){
        player = new Player("Sam");
        card1 = new Card(Suit.SPADES.toString(), Value.ACE.toString(), Value.ACE.getValue());
        card2 = new Card(Suit.HEARTS.toString(), Value.ACE.toString(), Value.ACE.getValue());
        card3 = new Card(Suit.HEARTS.toString(), Value.KING.toString(), Value.KING.getValue());
        card4 = new Card(Suit.HEARTS.toString(), Value.QUEEN.toString(), Value.KING.getValue());
    }

    @Test
    public void testGetName(){
        assertEquals("Sam", player.getName());
    }

    @Test
    public void testCards(){
        player.addCard(card3);
        player.addCard(card4);
        assertEquals(20, player.sumCards());
    }

    @Test
    public void testAceCheck(){
        player.addCard(card1);
        player.addCard(card3);
        player.addCard(card4);
        player.aceCheck();
        assertEquals(21, player.sumCards());
    }

    @Test
    public void testDoubleAce(){
        player.addCard(card1);
        player.addCard(card2);
        player.aceCheck();
        assertEquals(12, player.sumCards());
    }

    @Test
    public void testBustCheck(){
        player.addCard(card1);
        player.addCard(card2);
        player.addCard(card3);
        player.addCard(card4);
        assertTrue(player.bustCheck());
    }

}
