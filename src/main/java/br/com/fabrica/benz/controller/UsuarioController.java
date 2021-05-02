package br.com.fabrica.benz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabrica.benz.controller.dto.UsuarioDTO;
import br.com.fabrica.benz.model.Usuario;
import br.com.fabrica.benz.repository.UsuarioRepository;

@RestController
public class UsuarioController{
    
    @Autowired
    public UsuarioRepository usuarioRepository;

    @RequestMapping("/usuarios")
    public List<UsuarioDTO> listaTodosOsUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return UsuarioDTO.converter(usuarios);
    }
}
