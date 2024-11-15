package com.backcasino.controller;

import com.backcasino.DTO.PlayerStatisticDTO;
import com.backcasino.models.Performance;
import com.backcasino.services.PlayerStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/playerStatistics")
public class PlayerStatisticController {

    @Autowired
    private PlayerStatisticService playerStatisticService;

    @PostMapping("/{playerId}")
    public ResponseEntity<PlayerStatisticDTO> getPlayerStatistics(@PathVariable Integer playerId) {
        Performance performance = playerStatisticService.findByPlayerId(playerId);
        System.out.println(performance);
        PlayerStatisticDTO playerStatisticDTO = new PlayerStatisticDTO(performance);
        return ResponseEntity.ok(playerStatisticDTO);
    }
}
