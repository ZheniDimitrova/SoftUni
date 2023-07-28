package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByEmail(String email);
    @Query("select p from Player p join p.stat s  where  year(p.birthDate) > 1994 and year(p.birthDate) < 2004 order by s.shooting desc, s.passing desc, s.endurance desc, p.lastName")
    List<Player> findTheBestPlayers();
}
