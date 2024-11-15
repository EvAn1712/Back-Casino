package com.backcasino.services;

import com.backcasino.DAO.BetDAO;
import com.backcasino.DAO.PlayerDAO;
import com.backcasino.models.Bet;
import com.backcasino.models.Game;
import com.backcasino.models.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BetService {

    @Autowired
    private BetDAO betDAO;

    @Autowired
    private PlayerDAO playerDAO;

    @Transactional
    public Bet placeBet(int amount, Player player, Game game) {
        Bet bet = new Bet(player, game, amount, 0);
        betDAO.save(bet);
        return bet;
    }

    @Transactional
    public void resolveBet(Bet bet, String result) {
        Player player = playerDAO.findById(bet.getPlayer().getId()).orElseThrow(() -> new IllegalArgumentException("Player not found"));

        switch (result) {
            case "win":
                player.setTokenBalance(player.getTokenBalance() + bet.getAmount() * 2);
                bet.setOutcome(bet.getAmount() * 2);
                break;
            case "lose":
                bet.setOutcome(bet.getAmount() * -1);
                break;
            case "draw":
                player.setTokenBalance(player.getTokenBalance() + bet.getAmount());
                bet.setOutcome(0);
                break;
            default:
                throw new IllegalArgumentException("Invalid result");
        }
        playerDAO.save(player);
        betDAO.save(bet);
    }

    public void deleteBet(Integer id) {
        betDAO.deleteById(id);
    }

    public void deleteAllBets() {
        betDAO.deleteAll();
    }

    public Bet getBet(Integer id) {
        return betDAO.findById(id).orElseThrow(() -> new IllegalArgumentException("Bet not found"));
    }
}