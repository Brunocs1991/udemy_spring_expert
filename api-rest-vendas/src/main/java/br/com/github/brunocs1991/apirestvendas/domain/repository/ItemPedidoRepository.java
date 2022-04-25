package br.com.github.brunocs1991.apirestvendas.domain.repository;

import br.com.github.brunocs1991.apirestvendas.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
