package org.gabo.ejemplos.servicios.listas.repo;

import org.gabo.ejemplos.servicios.listas.database.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositorio extends JpaRepository<Usuario, Long>{
    
}