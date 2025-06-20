package com.gustavosdaniel.loja_de_jogos.user;

import com.gustavosdaniel.loja_de_jogos.common.BaseEntity;
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
@Table(name = "_user")
public class User extends BaseEntity {
    ;;
    private String firstName;
    private String lastName;
    private String email;
    private String profilePicture;
}
