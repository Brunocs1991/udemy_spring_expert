package br.com.github.brunocs1991.apirestvendas.domain.repository;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
