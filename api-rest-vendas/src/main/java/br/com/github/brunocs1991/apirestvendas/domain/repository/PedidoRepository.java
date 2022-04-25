package br.com.github.brunocs1991.apirestvendas.domain.repository;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p LEFT JOIN FETCH p.itens WHERE p.id = :id")
    Optional<Pedido> findByIdFetchItens(@Param("id") Integer id);
}
