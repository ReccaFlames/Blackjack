package org.example;

import org.example.blackjack.BlackjackGame;
import org.example.deck.DeckProvider;

public class Main {

    private static final DeckProvider deckProvider = new DeckProvider();
    private static final BlackjackGame blackjack = new BlackjackGame(deckProvider);

    public static void main(String[] args) {
        var filename = args.length > 0 ? args[0] : null;
        var result = blackjack.play(filename);
        result.printResult();
    }
}