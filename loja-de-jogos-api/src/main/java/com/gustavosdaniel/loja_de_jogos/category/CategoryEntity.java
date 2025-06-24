package com.gustavosdaniel.loja_de_jogos.category;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import com.gustavosdaniel.loja_de_jogos.game.GameEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NamedQueries({ //AQUI JA É UMA LISTA DE CONSULTA NOMEADA
        @NamedQuery(name = "Category.namedQueryFindByName",
                query = "SELECT c FROM CategoryEntity c" +
                        " WHERE c.name LIKE lower(:catName)" +
                        "ORDER BY c.name ASC ") // CONSULTA NOMEADA
})

public class CategoryEntity extends BaseEntity {

    private String name;
    private String description;

    @OneToMany(mappedBy = "category") //em UMA categoria pode ter MUITOS jogos e (mappedBy = "category") term que ter o mesmo nome que na entidade jogo " private Category category;"
    private List<GameEntity> games;
}
