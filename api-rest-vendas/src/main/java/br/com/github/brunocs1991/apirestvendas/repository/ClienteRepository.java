package br.com.github.brunocs1991.apirestvendas.repository;

import br.com.github.brunocs1991.apirestvendas.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
