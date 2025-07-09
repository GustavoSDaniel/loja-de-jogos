package com.gustavosdaniel.loja_de_jogos.common;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse <T>{ // PAGINAÇÃO MELHORA NO DESEMPENHO POIS NÃO VAI PRECISAR BUSCAR TUDO DE UMA VEZ NO BANCO DE DADOS

    private List<T> content;
    private int pageNumber;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean isLast;
    private boolean isFirst;
}
