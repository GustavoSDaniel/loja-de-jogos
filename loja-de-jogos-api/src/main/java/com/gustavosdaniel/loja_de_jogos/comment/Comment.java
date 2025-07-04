package com.gustavosdaniel.loja_de_jogos.comment;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import com.gustavosdaniel.loja_de_jogos.game.Game;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends BaseEntity {

    private String name;
    private String comment;

    @ManyToOne//MUITOS comentarios dentro de  UMA jogo
    @JoinColumn(name = "id_game") // NOME NA TABELA DO BANCO DE DADOS sem o joincolumn seria comment_id
    private Game game;
}
