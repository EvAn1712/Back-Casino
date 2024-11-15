package com.backcasino.DAO;

import com.backcasino.models.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDAO extends CrudRepository<Game, Integer> {
}
