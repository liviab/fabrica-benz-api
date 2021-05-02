package br.com.fabrica.benz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabrica.benz.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByCarrosModel(String nomeDoCarro);

	List<Usuario> findByFirstname(String nome);

}
