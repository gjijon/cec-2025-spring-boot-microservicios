package org.gabo.ejemplos.servicios.listas;

import org.gabo.ejemplos.servicios.listas.database.Usuario;
import org.gabo.ejemplos.servicios.listas.dto.UsuarioDTO;
import org.gabo.ejemplos.servicios.listas.servicios.ServiciosUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api", produces="application/json")
public class ControladorUsuario {

    @Autowired
    private ServiciosUsuario userServices;

    @GetMapping("hola")
    @CrossOrigin("*")
    public UsuarioDTO getHola() {
        UsuarioDTO u = new UsuarioDTO("Gabriel");
        return u;
    }

    @PostMapping("crearUsuario/{nombre}")
    public UsuarioDTO crearUsuario(@PathVariable String nombre) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUserName(nombre);
        userServices.guardaUsuario(nuevoUsuario); 
        return new UsuarioDTO(nuevoUsuario);
    }
}
