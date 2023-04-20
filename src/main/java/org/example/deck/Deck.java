package org.example.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import org.example.enums.Rank;
import org.example.enums.Suit;

public class Deck {
    private final Queue<String> cards;

    public Deck(boolean createDeck) {
        List<String> orderedDeck = new ArrayList<>();
        if (createDeck) {
            for (Suit suit: Suit.values()) {
                for (Rank rank: Rank.values()) {
                    orderedDeck.add(String.valueOf(suit) + rank);
                }
            }
        }
        Collections.shuffle(orderedDeck, new Random());
        this.cards = new LinkedList<>(orderedDeck);
    }

    public Deck(List<String> values) {
        this.cards = new LinkedList<>(values);
    }

    public Queue<String> getCards() {
        return cards;
    }

    public String getCard() {
        return cards.poll();
    }

    @Override
    public String toString() {
        return String.join(",", cards);
    }
}
