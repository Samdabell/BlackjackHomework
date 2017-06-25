package com.example.sam.blackjackhomework;

import java.util.ArrayList;

/**
 * Created by Sam on 23/06/2017.
 */

public class Game {

    private int numPlayers;
    private ArrayList<Player> players;
    private Player dealer;
    private ArrayList<Player> winners;
    private ArrayList<Player> losers;

    public Game(int numPlayers){
        this.numPlayers = numPlayers;
        players = new ArrayList<Player>();
        dealer = new Player("Dealer");
        winners = new ArrayList<Player>();
        losers = new ArrayList<Player>();
    }

    public int playerCount(){
        return this.numPlayers;
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void addWinner(Player winner){
        winners.add(winner);
    }

    public void addLoser(Player loser){
        losers.add(loser);

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Player> getWinners() {
        return winners;
    }

    public ArrayList<Player> getLosers() {
        return losers;
    }

    public void removePlayer(Player player){
        players.remove(player);
    }

    public void showWinners(ArrayList<Player> winners){
        System.out.println("The winners are:");
        for (Player winner : winners){
            System.out.println(winner.getName());
        }
    }

    public void showLosers(ArrayList<Player> losers){
        System.out.println("The losers are:");
        for (Player loser : losers){
            System.out.println(loser.getName());
        }
    }

    public Player getDealer(){
        return dealer;
    }



}
