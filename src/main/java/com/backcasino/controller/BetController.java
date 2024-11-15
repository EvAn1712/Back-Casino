package com.backcasino.controller;

import com.backcasino.DTO.BetRequestDTO;
import com.backcasino.DTO.BetResponseDTO;
import com.backcasino.models.Bet;
import com.backcasino.models.Game;
import com.backcasino.models.Player;
import com.backcasino.services.BetService;
import com.backcasino.services.GameService;
import com.backcasino.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/bet")
public class BetController {

    @Autowired
    private BetService betService;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private GameService gameService;

    @PostMapping("/place")
    public ResponseEntity<BetResponseDTO> placeBet(@RequestBody BetRequestDTO betRequest) {
        Player player = playerService.findById(betRequest.getPlayerId());
        Game game = gameService.findById(betRequest.getGameId());

        if (player == null || game == null) {
            return ResponseEntity.badRequest().body(null);
        }

        Bet bet = betService.placeBet(betRequest.getAmount(), player, game);
        game.setBet(bet); // Associate the bet with the game
        gameService.save(game); // Save the game with the associated bet

        BetResponseDTO betResponse = new BetResponseDTO(bet);
        return ResponseEntity.ok(betResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BetResponseDTO> getBet(@PathVariable Integer id) {
        Bet bet = betService.getBet(id);
        BetResponseDTO betResponse = new BetResponseDTO(bet);
        return ResponseEntity.ok(betResponse);
    }

    @PostMapping("/resolve/{id}")
    public ResponseEntity<BetResponseDTO> resolveBet(@PathVariable Integer id, @RequestParam String result) {
        Bet bet = betService.getBet(id);
        if (bet == null) {
            return ResponseEntity.notFound().build();
        }

        betService.resolveBet(bet, result);
        BetResponseDTO betResponse = new BetResponseDTO(bet);
        return ResponseEntity.ok(betResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBet(@PathVariable Integer id) {
        try {
            betService.deleteBet(id);
            return ResponseEntity.ok("{msg : Bet deleted successfully}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{msg : Error deleting bet}");
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllBets() {
        betService.deleteAllBets();
        return ResponseEntity.ok("{msg : All bets deleted successfully}");
    }
}