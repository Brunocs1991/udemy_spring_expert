package br.com.github.brunocs1991.apirestvendas.rest.controller;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Usuario;
import br.com.github.brunocs1991.apirestvendas.service.impl.UsuarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioServiceImpl usuarioService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario){
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioService.salvar(usuario);
    }
}
