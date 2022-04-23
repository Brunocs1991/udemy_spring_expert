package github.brunocs1991.jpa.domain.repository;

import github.brunocs1991.jpa.domain.entity.Cliente;
import github.brunocs1991.jpa.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);
}
