package com.backcasino.DAO;

import com.backcasino.models.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetDAO extends CrudRepository<Bet, Integer> {
}