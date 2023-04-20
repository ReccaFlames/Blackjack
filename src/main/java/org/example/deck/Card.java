package org.example.deck;

import org.example.enums.Rank;
import org.example.enums.Suit;

public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue(){
        return rank.getRankValue();
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }
}
