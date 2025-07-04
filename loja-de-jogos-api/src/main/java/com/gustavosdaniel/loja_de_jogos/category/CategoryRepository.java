package com.gustavosdaniel.loja_de_jogos.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // BUSCA PELO NOME PELO COMEÇO DA PALAVRA E IGNORA SE TA EM MAIUSCULO OU MINUSCULO
    List<Category> findByNameStartingWithIgnoreCaseOrderByNameAsc(String name);

    //JPQL
    @Query("""
         SELECT c FROM Category c
         WHERE c.name LIKE lower(:catName) 
         ORDER BY c.name ASC 
         """)
    List<Category> findByName(@Param("catName") String categoryName);

    @Query
    List<Category> namedQueryFindByName(@Param("catName") String categoryName);
}
