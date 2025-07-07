package com.gustavosdaniel.loja_de_jogos.category;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import com.gustavosdaniel.loja_de_jogos.game.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder//permite que você use o padrão Builder de forma fluida em uma hierarquia de classes (superclasses e subclasses)
public class Category extends BaseEntity {

    private String name;
    private String description;

    @OneToMany(mappedBy = "category") //em UMA categoria pode ter MUITOS jogos e (mappedBy = "category") term que ter o mesmo nome que na entidade jogo " private Category category;"
    private List<Game> games;
}
