package br.com.fabrica.benz.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabrica.benz.controller.dto.CarroDTO;
import br.com.fabrica.benz.model.Carro;


@RestController
public class CarroController {
	
	@RequestMapping("/carros")
	public List<CarroDTO> lista() {
		Carro carro = new Carro(2020, "QFI-0622", "Fiesta", "branco");
		return CarroDTO.converter(Arrays.asList(carro, carro, carro));
	}
}
