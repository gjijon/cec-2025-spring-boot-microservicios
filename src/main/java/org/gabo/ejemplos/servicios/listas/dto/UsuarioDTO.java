package org.gabo.ejemplos.servicios.listas.dto;

import java.time.Instant;
import java.time.LocalDateTime;

import org.gabo.ejemplos.servicios.listas.database.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private String userName;
    private LocalDateTime lastLogin;

    public UsuarioDTO(String userName) {
        this.userName = userName;
        this.lastLogin = LocalDateTime.now();
    }

    public UsuarioDTO(Usuario u) {
        this.userName = u.getUserName();
        if(u.getFechaUltimoLogin() != null ) {
            this.lastLogin = LocalDateTime.ofInstant(Instant.ofEpochSecond(u.getFechaUltimoLogin().getTime()), null);
        }
    }
}
