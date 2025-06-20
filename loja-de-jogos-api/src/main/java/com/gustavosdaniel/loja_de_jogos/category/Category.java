package com.gustavosdaniel.loja_de_jogos.category;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseEntity {

    private String name;
    private String description;
}
