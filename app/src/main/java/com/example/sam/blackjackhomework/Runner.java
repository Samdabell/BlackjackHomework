package com.example.sam.blackjackhomework;

import com.example.sam.blackjackhomework.Enum.Choice;

import java.util.Scanner;

/**
 * Created by Sam on 23/06/2017.
 */

public class Runner {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of players");
        Integer numPlayers = new Integer(sc.nextLine());

        Deck deck = new Deck();
        deck.makeDeck();
        deck.shuffle();

        Game game = new Game(numPlayers);

        for (int i = 0; i < game.playerCount(); i++)
        {
            System.out.println(String.format("Player %d name: ", i + 1));
            Player newPlayer = new Player(sc.nextLine());
            game.addPlayer(newPlayer);
        }

        for (Player player : game.getPlayers()){
            player.addCard(deck.drawCard());
            player.addCard(deck.drawCard());
            System.out.println(String.format("%s drew:", player.getName()));
            for (Card card : player.getCards()){
                System.out.println(card.viewCard());
            }
            player.aceCheck();
            System.out.println(String.format("%s's total is %s", player.getName(), player.sumCards()));
            if (player.bustCheck()){
                System.out.println(String.format("%s is bust", player.getName()));
                game.addLoser(player);
                game.removePlayer(player);
            }
            else if (player.sumCards() == 21) {
                System.out.println(String.format("%s has won", player.getName()));
                game.addWinner(player);
                game.removePlayer(player);
            }
        }
        Player dealer = game.getDealer();
        Card dealerCard = deck.drawCard();
        dealer.addCard(dealerCard);
        dealer.addCard(deck.drawCard());
        System.out.println(String.format("Dealer drew %s and one other card", dealerCard.viewCard()));

        for (int i = 0; i < game.playerCount(); i++) {
            Player player = game.getPlayers().get(i);
            System.out.println(String.format("Player %s", player.getName()));
            System.out.println(String.format("Hit or Stick?"));
            String choice = new String(sc.nextLine());
            if (choice.equals(Choice.HIT.getChoice())) {
                Card newCard = deck.drawCard();
                player.addCard(newCard);
                System.out.println(String.format("%s drew %s", player.getName(), newCard.viewCard()));
                player.aceCheck();
                System.out.println(String.format("%s's total is %s", player.getName(), player.sumCards()));
                if (player.bustCheck()) {
                    System.out.println(String.format("%s is bust", player.getName()));
                    game.addLoser(player);
                    continue;
                }
                else if (player.sumCards() == 21) {
                    System.out.println(String.format("%s has won", player.getName()));
                    game.addWinner(player);
                    continue;
                }
                i--;

            }
        }
        System.out.println("Dealer's cards are:");
        for (Card card : dealer.getCards()){
            System.out.println(card.viewCard());
        }
        System.out.println(String.format("Dealer's total is %s", dealer.sumCards()));
        while (dealer.sumCards() < 17){
            Card newCard = deck.drawCard();
            dealer.addCard(newCard);
            System.out.println(String.format("Dealer drew %s", newCard.viewCard()));
            dealer.aceCheck();
            System.out.println(String.format("Dealer's total is %s", dealer.sumCards()));
            if (dealer.bustCheck()) {
                System.out.println("Dealer is bust");
            }

        }

        for (Player player : game.getPlayers()) {
            if (!player.bustCheck() && !dealer.bustCheck() && player.sumCards() > dealer.sumCards()){
                game.addWinner(player);
            }
            if (!player.bustCheck() && dealer.bustCheck()){
                game.addWinner(player);
            }
            else if (!player.bustCheck() && !dealer.bustCheck() && player.sumCards() <= dealer.sumCards()){
                game.addLoser(player);
            }
        }
        game.showWinners(game.getWinners());
        game.showLosers(game.getLosers());
    }
}
