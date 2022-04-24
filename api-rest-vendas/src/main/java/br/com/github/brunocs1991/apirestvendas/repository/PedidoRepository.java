package br.com.github.brunocs1991.apirestvendas.repository;

import br.com.github.brunocs1991.apirestvendas.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
