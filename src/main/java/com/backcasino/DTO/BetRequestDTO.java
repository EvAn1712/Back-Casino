package com.backcasino.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BetRequestDTO {
    private Integer playerId;
    private Integer gameId;
    private int amount;

    public BetRequestDTO() {
    }
}
