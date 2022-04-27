package br.com.github.brunocs1991.apirestvendas.service.impl;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Usuario;
import br.com.github.brunocs1991.apirestvendas.domain.repository.UsuarioRepository;
import br.com.github.brunocs1991.apirestvendas.exception.SenhaInvalidaException;
import br.com.github.brunocs1991.apirestvendas.rest.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional
    public UsuarioDTO salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
        return UsuarioDTO
                .builder()
                .codigo(usuario.getId())
                .admin(usuario.isAdmin())
                .login(usuario.getLogin())
                .build();
    }

    public UserDetails autenticar(Usuario usuario) {
        UserDetails user = loadUserByUsername(usuario.getLogin());
            boolean senhasBatem = passwordEncoder.matches(usuario.getSenha(), user.getPassword());
        if (senhasBatem) {
            return user;
        }
        throw new SenhaInvalidaException();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioRepository.findByLogin(username).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não encontrado na base de dados")
        );

        String[] roles = usuario.isAdmin() ? new String[]{"ADMIN", "USER"} : new String[]{"USER"};

        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(roles)
                .build();
    }
}
