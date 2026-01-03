package com.blindBattles.BlindBattles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blindBattles.BlindBattles.Model.Battle;

public interface BattleRepository extends JpaRepository<Battle, String>{

}
