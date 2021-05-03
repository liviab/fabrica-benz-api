package br.com.fabrica.benz.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fabrica.benz.controller.dto.UsuarioDTO;
import br.com.fabrica.benz.controller.form.UsuarioForm;
import br.com.fabrica.benz.model.Usuario;
import br.com.fabrica.benz.repository.UsuarioRepository;


@RestController
@RequestMapping("/api/users")
public class UsuarioController{
    
    @Autowired
    public UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioDTO> listaTodosOsUsuarios(String firstname){
        List<Usuario> usuarios;

        if (firstname != null){
            usuarios = usuarioRepository.findByFirstname(firstname);
        }
        else{
            usuarios = usuarioRepository.findAll();
        }
        return UsuarioDTO.converter(usuarios);
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastraUsuario(@RequestBody @Valid UsuarioForm usuarioForm, UriComponentsBuilder uriBuilder){
        Usuario usuario = usuarioForm.converter();
        URI uri = uriBuilder.path("/api/users/{id}").buildAndExpand(usuario.getId()).toUri();
        
        usuarioRepository.save(usuario);
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }

}
