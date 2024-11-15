package com.backcasino.models;


import lombok.Getter;
import lombok.Setter;

@Getter
public enum Card {
    TWO_OF_HEARTS("H", "2", 2),
    THREE_OF_HEARTS("H", "3", 3),
    FOUR_OF_HEARTS("H", "4", 4),
    FIVE_OF_HEARTS("H", "5", 5),
    SIX_OF_HEARTS("H", "6", 6),
    SEVEN_OF_HEARTS("H", "7", 7),
    EIGHT_OF_HEARTS("H", "8", 8),
    NINE_OF_HEARTS("H", "9", 9),
    TEN_OF_HEARTS("H", "10", 10),
    JACK_OF_HEARTS("H", "J", 10),
    QUEEN_OF_HEARTS("H", "Q", 10),
    KING_OF_HEARTS("H", "K", 10),
    ACE_OF_HEARTS("H", "A", 11),

    TWO_OF_DIAMONDS("D", "2", 2),
    THREE_OF_DIAMONDS("D", "3", 3),
    FOUR_OF_DIAMONDS("D", "4", 4),
    FIVE_OF_DIAMONDS("D", "5", 5),
    SIX_OF_DIAMONDS("D", "6", 6),
    SEVEN_OF_DIAMONDS("D", "7", 7),
    EIGHT_OF_DIAMONDS("D", "8", 8),
    NINE_OF_DIAMONDS("D", "9", 9),
    TEN_OF_DIAMONDS("D", "10", 10),
    JACK_OF_DIAMONDS("D", "J", 10),
    QUEEN_OF_DIAMONDS("D", "Q", 10),
    KING_OF_DIAMONDS("D", "K", 10),
    ACE_OF_DIAMONDS("D", "A", 11),

    TWO_OF_CLUBS("C", "2", 2),
    THREE_OF_CLUBS("C", "3", 3),
    FOUR_OF_CLUBS("C", "4", 4),
    FIVE_OF_CLUBS("C", "5", 5),
    SIX_OF_CLUBS("C", "6", 6),
    SEVEN_OF_CLUBS("C", "7", 7),
    EIGHT_OF_CLUBS("C", "8", 8),
    NINE_OF_CLUBS("C", "9", 9),
    TEN_OF_CLUBS("C", "10", 10),
    JACK_OF_CLUBS("C", "J", 10),
    QUEEN_OF_CLUBS("C", "Q", 10),
    KING_OF_CLUBS("C", "K", 10),
    ACE_OF_CLUBS("C", "A", 11),

    TWO_OF_SPADES("S", "2", 2),
    THREE_OF_SPADES("S", "3", 3),
    FOUR_OF_SPADES("S", "4", 4),
    FIVE_OF_SPADES("S", "5", 5),
    SIX_OF_SPADES("S", "6", 6),
    SEVEN_OF_SPADES("S", "7", 7),
    EIGHT_OF_SPADES("S", "8", 8),
    NINE_OF_SPADES("S", "9", 9),
    TEN_OF_SPADES("S", "10", 10),
    JACK_OF_SPADES("S", "J", 10),
    QUEEN_OF_SPADES("S", "Q", 10),
    KING_OF_SPADES("S", "K", 10),
    ACE_OF_SPADES("S", "A", 11);

    // Propriétés de l'enum
    private final String suit;
    private final String rank;
    private final int value;

    Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

}