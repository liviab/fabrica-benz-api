package br.com.fabrica.benz.controller.form;

import br.com.fabrica.benz.model.Carro;
import br.com.fabrica.benz.repository.CarroRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AtualizacaoCarroForm {

    @NotNull
    private String licenseplate;
    @NotNull
    private String color;
    
    public String getLicenseplate() {
        return licenseplate;
    }
    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Carro atualizar(Long id, CarroRepository carroRepository){
        Carro carro = carroRepository.getOne(id);
        if (this.licenseplate.length() >= 1) {
            carro.setLicenseplate(this.licenseplate);
        }
        if (this.color.length() >= 1) {
            carro.setColor(this.color);
        }
        return carro;
    }
}
