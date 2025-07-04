package com.gustavosdaniel.loja_de_jogos.game;

import com.gustavosdaniel.loja_de_jogos.common.PageResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor // ESSA ANOTAÇÃO CRIA CONSTRUTORES SO QUE COM FINAL facilitando a injeção de dependencias
public class GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;

    public String saveGame(final GameRequest gameRequest) { // o FINAL garante que o objeto não seja alterado

        return null;

    }

    public void updateGame(String gameId, GameRequest gameRequest) {

    }

    public String uploadGameImage(MultipartFile file, String gameId) { // MultipartFile é essencial para qualquer aplicação Spring que precise lidar com upload de arquivos, desde fotos de perfil até importação de planilhas

        return null;
    }

    public PageResponse<GameResponse> findAllGames(int page, int size) {

        return null;

    }

    public void deleteGame(String gameId) {

    }
}
