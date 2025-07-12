package org.gabo.ejemplos.servicios.listas;

import java.util.ArrayList;

import org.gabo.ejemplos.servicios.listas.database.Usuario;
import org.gabo.ejemplos.servicios.listas.servicios.ServiciosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class ControladorUsuario {

    @Autowired
    private ServiciosUsuario userServices;

    @GetMapping("hola")
    public Usuario getHola() {
        Usuario u = new Usuario();
        u.setUserName("GabrielUsuario");
        return u;
    }

    @PutMapping("crearUsuario/{usuario}/{nombre}/{apellido}")
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

    @PostMapping("modificarUsuario/{id}/{usuario}/{nombre}/{apellido}")
    public Usuario modificaUsuario(
            @PathVariable Long id,
            @PathVariable String usuario,
            @PathVariable String nombre,
            @PathVariable String apellido) {
        Usuario usuarioModificar = userServices.getUsuario(id);
        usuarioModificar.setUserName(usuario);
        usuarioModificar.setUserNombre(nombre);
        usuarioModificar.setUserApellido(apellido);
        userServices.actualizaUsuario(usuarioModificar);
        return usuarioModificar;
    }

    @DeleteMapping("borrarUsuario/{id}")
    public void borraUsuario(
            @PathVariable Long id) {
        Usuario usuarioBorrar = userServices.getUsuario(id);
        userServices.borraUsuario(usuarioBorrar);
    }

    @GetMapping("consultaUsuarios")
    public ArrayList<Usuario> getAllUsers() {
        return userServices.getAllUsers();
    }
}
