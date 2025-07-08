package org.gabo.ejemplos.servicios.listas.database;

import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@JsonPropertyOrder({ "id", "usuario", "nombre", "apellido", "ultimoLogin" })
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("usuario")
    private String userName;
    @JsonProperty("nombre")
    private String userNombre;
    @JsonProperty("apellido")
    private String userApellido;
    @JsonIgnore
    private Date fechaCreacion;
    @JsonProperty("ultimoLogin")
    private Date fechaUltimoLogin;

    public Usuario() {
        this.fechaCreacion = new Date(Instant.now().toEpochMilli());
    }
}
