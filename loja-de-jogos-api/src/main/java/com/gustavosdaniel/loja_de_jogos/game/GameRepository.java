package com.gustavosdaniel.loja_de_jogos.game;


import com.gustavosdaniel.loja_de_jogos.platform.Console;
import com.gustavosdaniel.loja_de_jogos.platform.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface GameRepository extends JpaRepository<Game, String>, JpaSpecificationExecutor<Game> {

    @Query("""
        SELECT p FROM Platform p
                WHERE p.console IN :consoles
       """)
    List<Platform> findAllByConsoleIn(@Param("consoles") List<Console> selectConsoles);

    boolean existsByTitle(String title);
}
