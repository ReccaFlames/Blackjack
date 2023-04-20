package org.example.player;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<String> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public List<String> getHand() {
        return cards;
    }

    public void takeCardFromDeck(String card) {
        cards.add(card);
    }

    public int calculatedValue() {
        int value = 0;

        for (String card: cards) {
           var cardValue = card.substring(1);
           value += getCardValue(cardValue);
        }

        return value;
    }

    private int getCardValue(String val) {
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException nfe) {
            if (List.of("J", "Q", "K").contains(val)) {
                return 10;
            } else if ("A".equals(val)) {
                return 11;
            } else {
                return 0;
            }
        }
    }
}
