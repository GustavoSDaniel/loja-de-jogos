package com.gustavosdaniel.loja_de_jogos.whishlist;


import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import com.gustavosdaniel.loja_de_jogos.game.Game;
import com.gustavosdaniel.loja_de_jogos.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class WhishList extends BaseEntity {

    private String name;

    @OneToOne()//UMA lista de desejo pode ter Um usuario
    private User user;

    @ManyToMany(mappedBy = "whishLists", fetch = FetchType.EAGER) // quando é MANYTOMANY sempre sera uma lista nas duas entidades e uma delas precisa ter o mappedBy para não criar duas listas
    // fetch = FetchType.EAGER SEVE PARA CARREGAR TODA A LISTA
    private List<Game> games;


}
