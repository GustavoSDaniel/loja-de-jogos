package com.gustavosdaniel.loja_de_jogos.whishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WhishListRepository extends JpaRepository<WhishList, String> {

    // SELECIONANDO O GAME ESPECIFICO DA LISTA DE DESEJO
    @Query("""
        SELECT COUNT(w)
        FROM WhishList w
        JOIN w.games g
        WHERE g.id = :gameId        
            """)
    long countByGameId(String gameId);
}
