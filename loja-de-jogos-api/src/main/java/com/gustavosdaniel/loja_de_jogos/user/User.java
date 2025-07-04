package com.gustavosdaniel.loja_de_jogos.user;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import com.gustavosdaniel.loja_de_jogos.gamerequest.GameRequestEntity;
import com.gustavosdaniel.loja_de_jogos.notification.Notification;
import com.gustavosdaniel.loja_de_jogos.whishlist.WhishList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User extends BaseEntity {
    ;;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePicture;

    @OneToOne(mappedBy = "user") //UM usuario pode ter Uma lista de desejo
    // EM RELACIONAMENTOS @OneToOne CRIA UM RELACIONAMENTO BIDIMENSIONAL QUE GERA UM LOOP PARA EVITAR ISSO COLOCAMOS O mappedBy PARA AQUELE QUE É O "DOMINANTE"
    // UMA LISTA DE DESEJO PRECISA DE UM USER (ENTÃO ELA É SUBMISSA)
    private WhishList whishList;

    @OneToMany(mappedBy = "user") // UM usuario recebe MUITAS notificações
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user") // UM usuario faz MUITAS requisições de jogos
    private List<GameRequestEntity> gameRequests;
}
