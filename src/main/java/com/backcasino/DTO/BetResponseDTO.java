package com.backcasino.DTO;

import com.backcasino.models.Bet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetResponseDTO {
    private Integer betId;
    private Integer playerId;
    private String playerUsername;
    private Integer gameId;
    private int amount;
    private int outcome;

    public BetResponseDTO(Bet bet) {
        this.betId = bet.getId();
        this.playerId = bet.getPlayer().getId();
        this.playerUsername = bet.getPlayer().getUsername();
        this.gameId = bet.getGame().getId();
        this.amount = bet.getAmount();
        this.outcome = bet.getOutcome();
    }
}
