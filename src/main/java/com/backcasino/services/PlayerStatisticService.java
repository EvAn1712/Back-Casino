package com.backcasino.services;

import com.backcasino.DAO.PlayerStatisticDAO;
import com.backcasino.models.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PlayerStatisticService {

    @Autowired
    private PlayerStatisticDAO playerStatisticDAO;

    public Performance createPlayerStatistics(Integer playerId, int gamesPlayed, int gamesWon, int gamesLost, int totalTokens, int totalBets) {
        Performance performance = new Performance(playerId, gamesPlayed, gamesWon, gamesLost, totalTokens, totalBets);
        return playerStatisticDAO.save(performance);
    }

    public Performance updatePlayerStatistics(Integer playerId, int gamesPlayed, int gamesWon, int gamesLost, int totalTokens, int totalBets) {
        Optional<Performance> existingStats = playerStatisticDAO.findById(playerId);

        if (existingStats.isPresent()) {
            Performance performance = existingStats.get();
            performance.setGamesPlayed(gamesPlayed);
            performance.setGamesWon(gamesWon);
            performance.setGamesLost(gamesLost);
            performance.setTotalTokens(totalTokens);
            performance.setTotalBets(totalBets);
            return playerStatisticDAO.save(performance);
        } else {
            throw new IllegalArgumentException("Player statistics not found for player ID: " + playerId);
        }
    }

    public Performance findByPlayerId(Integer playerId) {
        return playerStatisticDAO.findById(playerId).orElse(null);
    }

    public void deletePlayerStatistics(Integer playerId) {
        playerStatisticDAO.deleteById(playerId);
    }
}