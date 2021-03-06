package br.com.fabrica.benz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabrica.benz.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

	List<Carro> findByModel(String nomeDoCarro);
    
}
