package com.gustavosdaniel.loja_de_jogos.gamerequest;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import com.gustavosdaniel.loja_de_jogos.user.User;
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
public class GameRequestEntity extends BaseEntity {

    private String title;
    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @ManyToOne() // MUITAS requisições de jogos para UM usuario
    @JoinColumn(name = "id_user")
    private User user;
}
