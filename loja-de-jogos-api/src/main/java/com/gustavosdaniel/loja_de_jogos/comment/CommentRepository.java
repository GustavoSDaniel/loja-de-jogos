package com.gustavosdaniel.loja_de_jogos.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {

    long countByGameId(String gameId);
}
