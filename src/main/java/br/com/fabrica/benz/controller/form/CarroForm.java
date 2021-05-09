package br.com.fabrica.benz.controller.form;

import br.com.fabrica.benz.model.Carro;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CarroForm {

    @NotNull @NotEmpty
    private Integer year;
    @NotNull @NotEmpty
    private String licenseplate;
    @NotNull @NotEmpty
    private String model;
    @NotNull @NotEmpty
    private String color;
    
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getLicenseplate() {
        return licenseplate;
    }
    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Carro converter(){
        return new Carro(year, licenseplate, model, color);
    }
}
