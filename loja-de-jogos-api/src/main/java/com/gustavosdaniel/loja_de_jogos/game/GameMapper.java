package com.gustavosdaniel.loja_de_jogos.game;

import com.gustavosdaniel.loja_de_jogos.category.Category;
import com.gustavosdaniel.loja_de_jogos.platform.Platform;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameMapper {


    public Game toGame(GameRequest gameRequest) {
        return Game.builder()
                .title(gameRequest.title())
                .category(Category.builder().id(gameRequest.categoryId()).build())
                .build();

    }
}
