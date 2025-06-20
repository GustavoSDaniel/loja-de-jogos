package com.gustavosdaniel.loja_de_jogos.notification;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
import com.gustavosdaniel.loja_de_jogos.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

}
