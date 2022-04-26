package br.com.github.brunocs1991.apirestvendas.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(!username.equals("ciclano")){
            throw new UsernameNotFoundException("Usuário não encontrado na base.");
        }
        return User
                .builder()
                .password(passwordEncoder.encode("123"))
                .username("ciclano")
                .roles("USER", "ADMIN")
                .build();
    }
}
