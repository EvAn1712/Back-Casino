package com.backcasino.DTO;

import com.backcasino.models.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDTO {
    private Integer playerId;
    private String username;
    private int tokenBalance;

    public PlayerDTO(Player player) {
        this.playerId = player.getId();
        this.username = player.getUsername();
        this.tokenBalance = player.getTokenBalance();
    }
}
