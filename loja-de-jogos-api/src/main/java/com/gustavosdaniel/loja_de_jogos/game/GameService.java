package com.gustavosdaniel.loja_de_jogos.game;

import com.gustavosdaniel.loja_de_jogos.common.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // ESSA ANOTAÇÃO CRIA CONSTRUTORES SO QUE COM FINAL facilitando a injeção de dependencias
public class GameService {

    private final GameRepository gameRepository;

    public PageResponse<GameEntity> pagedResult(final int page, final int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "title")); // PAGINA VAI SER ORDENADA PELO TITULO
        Page<GameEntity> pagedResult = gameRepository.findAllCategoryByName("anyCat", pageable);

        return PageResponse.<GameEntity>builder()
                .content(pagedResult.getContent())
                .totalPages(pagedResult.getTotalPages())
                .totalElements(pagedResult.getNumberOfElements())
                .isFirst(pagedResult.isFirst())
                .isLast(pagedResult.isLast())
                .build();

    }

    public void queryByExampleCaseInsensitive() { // NESSE METODO CRIAMOS UM EXEMPLO DE COMO DEVE SER UMA PESQUISA JA INCLUINDO QUE PODE USAR MAIUSCULA OU MINUSCULA

        GameEntity game = new GameEntity();
        game.setTitle("Good Of War");
        game.setSupportedPlatforms(SupportedPlatforms.PC);

        ExampleMatcher matcher = ExampleMatcher.matchingAny() // matchingAny() é usado quando tem mais dee um criterio se fosse só um seria o matching()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<GameEntity> example = Example.of(game, matcher);

        List<GameEntity> result = gameRepository.findAll(example);
    }

    public void queryByExample() {
        Specification<GameEntity> specification = Specification.where(null);
        specification = specification.and(GameRepository.byGameTitle("Good Of War"))
                .and(GameRepository.bySupportedPlatform(SupportedPlatforms.PC));
        List<GameEntity> result = gameRepository.findAll(specification);

    }
}
