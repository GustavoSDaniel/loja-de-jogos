package com.gustavosdaniel.loja_de_jogos.comment;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends BaseEntity {

    private String comment;
}
