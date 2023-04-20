package org.example.player;

import java.util.List;

public class Player {

    private final String name;
    private final Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public List<String> getHand() {
        return hand.getHand();
    }

    public void addCard(String cardValue) {
        hand.takeCardFromDeck(cardValue);
    }

    public int getHandValue() {
        return hand.calculatedValue();
    }

    public boolean hasBlackjack(){
        return hand.calculatedValue() == 21;
    }

    public void printHand() {
        System.out.println(getName() +": " + String.join(",", getHand()));
    }
}
