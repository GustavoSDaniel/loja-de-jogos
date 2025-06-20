package com.gustavosdaniel.loja_de_jogos.game;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
