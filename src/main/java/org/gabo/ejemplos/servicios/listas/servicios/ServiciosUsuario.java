package org.gabo.ejemplos.servicios.listas.servicios;

import java.util.ArrayList;

import org.gabo.ejemplos.servicios.listas.database.Usuario;
import org.gabo.ejemplos.servicios.listas.repo.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosUsuario {
    @Autowired
    private Repositorio repo;

    public Usuario getUsuario(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    public Usuario guardaUsuario(Usuario u) {
        return repo.save(u);
    }

    public Usuario actualizaUsuario(Usuario u) {
        return repo.save(u);
    }

    public void borraUsuario(Usuario u) {
        repo.delete(u);
    }

    public ArrayList<Usuario> getAllUsers() {
        return new ArrayList<>(repo.findAll().stream().toList());
    }
}
