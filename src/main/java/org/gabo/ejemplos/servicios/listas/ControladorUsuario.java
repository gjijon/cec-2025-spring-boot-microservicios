package org.gabo.ejemplos.servicios.listas;

import java.util.ArrayList;

import org.gabo.ejemplos.servicios.listas.database.Usuario;
import org.gabo.ejemplos.servicios.listas.servicios.ServiciosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ControladorUsuario {

    @Autowired
    private ServiciosUsuario userServices;

    @GetMapping("hola")
    @CrossOrigin("*")
    public Usuario getHola() {
        Usuario u = new Usuario();
        u.setUserName("GabrielUsuario");
        return u;
    }

    @PostMapping("crearUsuario/{usuario}/{nombre}/{apellido}")
    public Usuario crearUsuario(
            @PathVariable String usuario,
            @PathVariable String nombre,
            @PathVariable String apellido) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUserName(usuario);
        nuevoUsuario.setUserNombre(nombre);
        nuevoUsuario.setUserApellido(apellido);
        userServices.guardaUsuario(nuevoUsuario);
        return nuevoUsuario;
    }

    @GetMapping("consultaUsuarios")
    public ArrayList<Usuario> getAllUsers() {
        return userServices.getAllUsers();
    }
}
