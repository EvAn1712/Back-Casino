package com.backcasino.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Deck {
    private List<Card> cards = new ArrayList<>();

    public void initializeDeck() {
        for (Card card : Card.values()) {
            cards.add(card);
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Le paquet est vide, aucune carte à tirer.");
        }
        return cards.remove(0);
    }

    public int remainingCards() {
        return cards.size();
    }
}
