package com.gustavosdaniel.loja_de_jogos.game;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameResponse{

    private String id;
    private String name;
    private Set<String> platforms;
    private String imageUrl;
}
