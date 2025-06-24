package com.gustavosdaniel.loja_de_jogos.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    // BUSCA PELO NOME PELO COMEÇO DA PALAVRA E IGNORA SE TA EM MAIUSCULO OU MINUSCULO
    List<CategoryEntity> findByNameStartingWithIgnoreCaseOrderByNameAsc(String name);

    //JPQL
    @Query("""
         SELECT c FROM CategoryEntity c
         WHERE c.name LIKE lower(:catName) 
         ORDER BY c.name ASC 
         """)
    List<CategoryEntity> findByName( @Param("catName") String categoryName);

    @Query
    List<CategoryEntity> namedQueryFindByName(@Param("catName") String categoryName);
}
