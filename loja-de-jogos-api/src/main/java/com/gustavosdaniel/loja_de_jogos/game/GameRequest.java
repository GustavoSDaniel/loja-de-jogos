package com.gustavosdaniel.loja_de_jogos.game;

import com.gustavosdaniel.loja_de_jogos.platform.Platform;

import java.util.Set;

public record GameRequest(

    String title, //Não pode ter titulos duplicados
    String categoryId, // precisa verificar se essa categoria existe
    // SET Evita que a mesma plataforma seja associada múltiplas vezes ao mesmo jogo
    Set<Platform> platforms // precisa verificar se essa plataforma existe
) {
}
