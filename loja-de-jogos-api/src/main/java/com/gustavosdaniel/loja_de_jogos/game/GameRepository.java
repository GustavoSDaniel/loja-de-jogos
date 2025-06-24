package com.gustavosdaniel.loja_de_jogos.game;

import com.gustavosdaniel.loja_de_jogos.category.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<GameEntity, String> {

    // BUSQUE A LISTA DE JOGOS POR CATEGORIA (v1)
    List<GameEntity> findAllByCategory(CategoryEntity category);

    // BUSQUE A LISTA DE JOGOS POR CATEGORIA (v2)
    List<GameEntity> findAllByCategoryId(String categoryId);

    //JPQL
//    @Query("""
//            SELECT g FROM GameEntity g
//            INNER JOIN g.category c ON g.category = c.id
//            WHERE c.name LIKE :catName
//            """)]


    @Query("""
           SELECT g FROM GameEntity g
           INNER JOIN g.category c
           WHERE c.name LIKE :catName
           """)
    List<GameEntity> findAllByCat(@Param("catName") String catName);

    @Query("""
            UPDATE GameEntity SET title = upper(title) 
            """)
    @Modifying // ESSA QUERY vai modificar os titulos da tabela
    void transformGamesTitleToUpperCase();
}
