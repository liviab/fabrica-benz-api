package br.com.fabrica.benz.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.fabrica.benz.model.Usuario;

public class UsuarioDTO{

    public String firstName;
    public String lastName;

    public UsuarioDTO (Usuario usuario){
        this.firstName = usuario.getFirstName();
        this.lastName = usuario.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static List<UsuarioDTO> converter(List<Usuario> usuarios){
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

}