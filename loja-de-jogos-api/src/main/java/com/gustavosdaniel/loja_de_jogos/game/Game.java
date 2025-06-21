package com.gustavosdaniel.loja_de_jogos.game;

import com.gustavosdaniel.loja_de_jogos.category.Category;
import com.gustavosdaniel.loja_de_jogos.comment.Comment;
import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import com.gustavosdaniel.loja_de_jogos.whishlist.WhishList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game extends BaseEntity {

    private String title;
    @Enumerated(EnumType.STRING)
    private SupportedPlatforms supportedPlatforms;
    private String coverPicture;

    @ManyToOne //MUITOS jogos dentro de  UMA categoria
    @JoinColumn(name = "id_category") // NOME NA TABELA DO BANCO DE DADOS sem o joincolumn seria category_id
    private Category category;

    @OneToMany(mappedBy = "game") // UM jogo para MUITOS comentarios
    private List<Comment> comments;

    @ManyToMany() // quando é MANYTOMANY sempre sera uma lista nas duas entidades
    @JoinTable(
            name = "game_whishList",
            joinColumns = {
                    @JoinColumn(name = "id_game") // NOME DA ENTIDADE RAIZ
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_whishList") //NOME DA ENTIDADE SENDO IMPORTADA SEMPRE NESSA ORDEM
            }
    ) //TEM QUE SER NA ENTIDADE QUE NÃO CONTEM O mappedBy
    private List<WhishList> whishLists;
}
