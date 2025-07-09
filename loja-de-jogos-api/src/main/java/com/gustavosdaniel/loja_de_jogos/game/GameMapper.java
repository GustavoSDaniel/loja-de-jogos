package com.gustavosdaniel.loja_de_jogos.game;

import com.gustavosdaniel.loja_de_jogos.category.Category;
import com.gustavosdaniel.loja_de_jogos.platform.Platform;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameMapper {


    public Game toGame(GameRequest gameRequest) {
        return Game.builder()
                .title(gameRequest.title())
                .category(Category.builder().id(gameRequest.categoryId()).build())
                .build();

    }

    public GameResponse toGameResponse(Game game) {

        return GameResponse.builder()
                .id(game.getId())
                .title(game.getTitle())
                .platforms(game.getPlatforms()
                        .stream()
                        .map(platform -> platform.getConsole().name())
                        .collect(Collectors.toSet())  // para pegar o titulo do console que esta em enum
                )
                .imageUrl("")
                .build();


    }
}
