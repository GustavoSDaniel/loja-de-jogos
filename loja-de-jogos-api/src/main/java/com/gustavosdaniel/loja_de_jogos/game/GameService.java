package com.gustavosdaniel.loja_de_jogos.game;

import com.gustavosdaniel.loja_de_jogos.category.CategoryRepository;
import com.gustavosdaniel.loja_de_jogos.common.PageResponse;
import com.gustavosdaniel.loja_de_jogos.platform.Console;
import com.gustavosdaniel.loja_de_jogos.platform.Platform;
import com.gustavosdaniel.loja_de_jogos.platform.PlatformRepository;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor // ESSA ANOTAÇÃO CRIA CONSTRUTORES SO QUE COM FINAL facilitando a injeção de dependencias
@Slf4j
public class GameService {

    private final GameRepository gameRepository;
    private final GameMapper gameMapper;
    private final PlatformRepository platformRepository;
    private final CategoryRepository categoryRepository;

    public String saveGame(final GameRequest gameRequest) { // o FINAL garante que o objeto não seja alterado

       if (gameRepository.existsByTitle(gameRequest.title())){
           log.info("Game already exists with title {}", gameRequest.title());
            throw new RuntimeException("Game already exists");
       }

        final List<Console> selectConsoles = gameRequest.platforms()
                .stream()
                .map(Console::valueOf) //Console.valueOf("PLAYSTATION") retornaria o objeto Console.PLAYSTATION
                .toList();

        final List<Platform> platforms = gameRepository.findAllByConsoleIn(selectConsoles);

        if (platforms.size() != gameRequest.platforms().size()) {
            log.info("Received a non supported platforms. Received: {} - Stored: {}", selectConsoles,  platforms);

            throw new RuntimeException(" One or more platforms are not supported");
        }

        if (!categoryRepository.existsById(gameRequest.categoryId())){
            log.warn("Category with id {} not found", gameRequest.categoryId());
            throw new RuntimeException("Category does not exist");

        }

        final Game game = gameMapper.toGame(gameRequest);
        game.setPlatforms(platforms);
        final Game savedGame = gameRepository.save(game);
        return savedGame.getId();

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
