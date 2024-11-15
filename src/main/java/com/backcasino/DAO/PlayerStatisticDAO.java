package com.backcasino.DAO;

import com.backcasino.models.Performance;
import com.backcasino.models.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerStatisticDAO extends CrudRepository<Performance, Integer> {
}