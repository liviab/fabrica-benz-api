package br.com.fabrica.benz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabrica.benz.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
