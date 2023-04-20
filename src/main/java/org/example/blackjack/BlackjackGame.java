package org.example.blackjack;

import org.example.deck.Deck;
import org.example.deck.DeckProvider;
import org.example.player.Player;

public class BlackjackGame {
    private final DeckProvider deckProvider;

    public BlackjackGame(DeckProvider provider) {
        deckProvider = provider;
    }

    public Result play(String filename) {
        var deck = deckProvider.provide(filename);

        var sam = new Player("sam");
        var dealer = new Player("dealer");

        initCards(deck, sam, dealer);
        return playGame(deck, sam, dealer);
    }

    private void initCards(Deck deck, Player player, Player dealer) {
        player.addCard(deck.getCard());
        dealer.addCard(deck.getCard());
        player.addCard(deck.getCard());
        dealer.addCard(deck.getCard());
    }

    private Result playGame(Deck deck, Player sam, Player dealer) {
        if (sam.hasBlackjack()) {
            return new Result(sam.getName(), sam, dealer);
        }

        if (dealer.hasBlackjack()) {
            return new Result(dealer.getName(), sam, dealer);
        }

        if (sam.getHandValue() > 21 && dealer.getHandValue() > 21) {
            return new Result(dealer.getName(), sam, dealer);
        }

        for (String card: deck.getCards()) {
            if (sam.getHandValue() < 17) {
                sam.addCard(card);
                if (sam.hasBlackjack()) {
                    return new Result(sam.getName(), sam, dealer);
                } else if (sam.getHandValue() > 21) {
                    return new Result(dealer.getName(), sam, dealer);
                }
            } else {
                dealer.addCard(card);
                if (dealer.hasBlackjack()) {
                    return new Result(dealer.getName(), sam, dealer);
                } else if (dealer.getHandValue() > 21) {
                    return new Result(sam.getName(), sam, dealer);
                }
            }
        }

        return new Result("none", sam, dealer);
    }
}
