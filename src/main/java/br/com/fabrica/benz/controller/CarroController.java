package br.com.fabrica.benz.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fabrica.benz.controller.dto.CarroDTO;
import br.com.fabrica.benz.controller.form.CarroForm;
import br.com.fabrica.benz.model.Carro;
import br.com.fabrica.benz.repository.CarroRepository;


@RestController
@RequestMapping("/api/cars")
public class CarroController {

	@Autowired
	private CarroRepository carroRepository;
	
	@GetMapping
	public List<CarroDTO> listaTodosOsCarros(String model) {
		List<Carro> carros;
		if (model != null){
			carros = carroRepository.findByModel(model);
		}	
		else{
			carros = carroRepository.findAll();
		}
		return CarroDTO.converter(carros);
	}

	@PostMapping
	public ResponseEntity<CarroDTO> cadastrar(@RequestBody CarroForm carroForm, UriComponentsBuilder uriBuilder) {
		Carro carro = carroForm.converter();
		URI uri = uriBuilder.path("/api/cars/{id}").buildAndExpand(carro.getId()).toUri();

		carroRepository.save(carro);
		return ResponseEntity.created(uri).body(new CarroDTO(carro));
	}
}
