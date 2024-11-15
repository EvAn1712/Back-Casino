package com.backcasino.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameRequestDTO {
    @JsonProperty("game")
    private GameActionRequestDTO game;
}
