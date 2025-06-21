package com.gustavosdaniel.loja_de_jogos.notification;

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
public class Notification extends BaseEntity {


    private String message;
    private String receiver; //receptor
    private NotificationLevel level;
    private NotificationStatus status;

    @ManyToOne // MUITAS notificações para UM usuario
    @JoinColumn(name = "id_user")
    private User user;

}
