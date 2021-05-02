package br.com.fabrica.benz.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabrica.benz.controller.dto.CarroDTO;
import br.com.fabrica.benz.model.Carro;
import br.com.fabrica.benz.repository.CarroRepository;


@RestController
public class CarroController {

	@Autowired
	private CarroRepository carroRepository;
	
	@RequestMapping("/carros")
	public List<CarroDTO> lista() {
		List<Carro> carros = carroRepository.findAll();
		return CarroDTO.converter(carros);
	}
}
