package com.backcasino.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GameCreationRequest {

    private Integer playerId;
    private int betAmount;

    public GameCreationRequest() {}

    public GameCreationRequest(Integer playerId, int betAmount) {
        this.playerId = playerId;
        this.betAmount = betAmount;
    }

}