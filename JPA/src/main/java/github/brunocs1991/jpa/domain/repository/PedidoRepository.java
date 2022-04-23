package github.brunocs1991.jpa.domain.repository;

import github.brunocs1991.jpa.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
