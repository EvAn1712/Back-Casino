package com.backcasino.DTO;

import com.backcasino.models.Card;
import com.backcasino.models.Deck;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GameActionRequestDTO {
    private Integer gameId;
    private Integer playerId;
    private List<Card> playerHand;
    private List<Card> dealerHand;
    private int playerScore;
    private int dealerScore;
    private boolean isGameOver;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Deck deck;

    public GameActionRequestDTO() {
    }
}
