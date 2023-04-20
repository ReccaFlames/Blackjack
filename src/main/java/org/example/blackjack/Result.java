package org.example.blackjack;

import org.example.player.Player;

public class Result {

    private final String winner;
    private final Player player;
    private final Player dealer;

    public Result(String winner, Player player, Player dealer) {
        this.winner = winner;
        this.player = player;
        this.dealer = dealer;
    }

    public void printResult() {
        System.out.println(winner);
        player.printHand();
        dealer.printHand();
    }
}
