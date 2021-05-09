package br.com.fabrica.benz.controller;

import java.net.URI;
import java.util.List;

import br.com.fabrica.benz.controller.form.AtualizacaoCarroForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fabrica.benz.controller.dto.CarroDTO;
import br.com.fabrica.benz.controller.form.CarroForm;
import br.com.fabrica.benz.model.Carro;
import br.com.fabrica.benz.repository.CarroRepository;

import javax.validation.Valid;


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

	@GetMapping("/{id}")
	public CarroDTO detalharCarro (@PathVariable Long id){
		Carro carro = carroRepository.getOne(id);
		return new CarroDTO(carro);
	}

	@PostMapping
	@Transactional
	public ResponseEntity<CarroDTO> cadastrar(@RequestBody CarroForm carroForm, UriComponentsBuilder uriBuilder) {
		Carro carro = carroForm.converter();
		URI uri = uriBuilder.path("/api/cars/{id}").buildAndExpand(carro.getId()).toUri();

		carroRepository.save(carro);
		return ResponseEntity.created(uri).body(new CarroDTO(carro));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CarroDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoCarroForm form){
		Carro carro = form.atualizar(id, carroRepository);
		return ResponseEntity.ok(new CarroDTO(carro));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id){
		carroRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
