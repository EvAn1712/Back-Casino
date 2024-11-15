package com.backcasino.DAO;

import com.backcasino.models.Game;
import com.backcasino.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

@Repository
public interface PlayerDAO extends CrudRepository<Player, Integer> {
    Player findByUsername(String username);
}
