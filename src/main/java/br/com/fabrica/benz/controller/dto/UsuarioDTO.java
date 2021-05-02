package br.com.fabrica.benz.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fabrica.benz.model.Carro;
import br.com.fabrica.benz.model.Usuario;

public class UsuarioDTO{

    public String firstname;
    public String lastname;
    public List<Carro> carros;

    public UsuarioDTO (Usuario usuario){
        this.firstname = usuario.getFirstname();
        this.lastname = usuario.getLastname();
        this.carros = usuario.getCarros();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastName) {
        this.lastname = lastName;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> cars) {
        this.carros = cars;
    }

    public static List<UsuarioDTO> converter(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

}