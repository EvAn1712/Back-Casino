package com.backcasino.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "player_statistics")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "player_id", nullable = false, unique = true)
    private Integer playerId;

    @Column(name = "games_played", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int gamesPlayed;

    @Column(name = "games_won", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int gamesWon;

    @Column(name = "games_lost", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int gamesLost;

    @Column(name = "total_tokens", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int totalTokens;

    @Column(name = "total_bets", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int totalBets;

    @OneToOne
    @JoinColumn(name = "player_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Player player;

    public Performance() {}

    public Performance(Integer playerId, int gamesPlayed, int gamesWon, int gamesLost, int totalTokens, int totalBets) {
        this.playerId = playerId;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
        this.totalTokens = totalTokens;
        this.totalBets = totalBets;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", gamesPlayed=" + gamesPlayed +
                ", gamesWon=" + gamesWon +
                ", gamesLost=" + gamesLost +
                ", totalTokens=" + totalTokens +
                ", totalBets=" + totalBets +
                ", player=" + player +
                '}';
    }
}
