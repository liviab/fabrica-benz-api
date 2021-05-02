package br.com.fabrica.benz.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fabrica.benz.model.Carro;

public class CarroDTO {

	private Integer year;
	private String model;
	private String licensePlate;
	private String color;
	
	public CarroDTO(Carro carro) {
		this.model = carro.getModel();
		this.licensePlate = carro.getLicensePlate();
		this.color = carro.getColor();
		this.year = carro.getYear();
	}
	
	public String getModel() {
		return model;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}
	
	public String getColor() {
		return color;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public static List<CarroDTO> converter(List<Carro> carros){
		return carros.stream().map(CarroDTO::new).collect(Collectors.toList());
	}
	
}
