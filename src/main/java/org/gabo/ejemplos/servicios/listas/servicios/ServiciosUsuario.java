package org.gabo.ejemplos.servicios.listas.servicios;

import org.gabo.ejemplos.servicios.listas.database.Usuario;
import org.gabo.ejemplos.servicios.listas.repo.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosUsuario {
    @Autowired
    private Repositorio repo;

    public Usuario guardaUsuario(Usuario u) {
        return repo.save(u);
    }
}
