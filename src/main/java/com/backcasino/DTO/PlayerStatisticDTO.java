package com.backcasino.DTO;

import com.backcasino.models.Performance;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerStatisticDTO {
    private Integer playerId;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int totalTokens;
    private int totalBets;

    public PlayerStatisticDTO(Performance performance) {
        this.playerId = performance.getPlayerId();
        this.gamesPlayed = performance.getGamesPlayed();
        this.gamesWon = performance.getGamesWon();
        this.gamesLost = performance.getGamesLost();
        this.totalTokens = performance.getTotalTokens();
        this.totalBets = performance.getTotalBets();
    }
}