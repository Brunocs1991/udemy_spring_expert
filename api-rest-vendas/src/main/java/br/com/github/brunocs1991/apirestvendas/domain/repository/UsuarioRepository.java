package br.com.github.brunocs1991.apirestvendas.domain.repository;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByLogin(String login);
}
