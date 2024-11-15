package com.backcasino.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "bets")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Bet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int amount;
    private int outcome;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @OneToOne(mappedBy = "bet")
    private Game game;

    public Bet() {}

    public Bet(Player player, Game game, int amount, int outcome) {
        this.player = player;
        this.game = game;
        this.amount = amount;
        this.outcome = outcome;
    }
}