package br.com.github.brunocs1991.apirestvendas.domain.repository;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
