package com.backcasino.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bet_id", referencedColumnName = "id")
    private Bet bet;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @Transient
    private int dealerScore;
    @Transient
    private int playerScore;

    public enum GameStatus {
        PROGRESS,
        WIN,
        LOSE,
        DRAW
    }
    @Setter
    @Enumerated(EnumType.STRING)
    private GameStatus isGameOver;

    @Transient
    private List<Card> playerHand;
    @Transient
    private List<Card> dealerHand;
    @Transient
    private Deck deck;

    public Game() {
        this.playerHand = new ArrayList<>();
        this.dealerHand = new ArrayList<>();
        this.playerScore = 0;
        this.dealerScore = 0;
        this.isGameOver = GameStatus.PROGRESS;
        this.deck = new Deck();
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", player=" + player +
                ", bet=" + bet +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", dealerScore=" + dealerScore +
                ", playerScore=" + playerScore +
                ", gameStatus=" + isGameOver +
                ", playerHand=" + playerHand +
                ", dealerHand=" + dealerHand +
                ", deck=" + deck +
                '}';
    }
}