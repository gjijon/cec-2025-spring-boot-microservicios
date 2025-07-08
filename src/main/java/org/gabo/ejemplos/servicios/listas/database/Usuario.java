package org.gabo.ejemplos.servicios.listas.database;

import java.time.Instant;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private Date fechaCreacion;
    private Date fechaUltimoLogin;

    public Usuario() {
        this.fechaCreacion = new Date(Instant.now().toEpochMilli());
    }
}
