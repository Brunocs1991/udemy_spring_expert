package github.brunocs1991.jpa.domain.repository;

import github.brunocs1991.jpa.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT * FROM cliente c WHERE c.nome LIKE '%:nome%'", nativeQuery = true)
    List<Cliente> encontrarPorNome( @Param("nome") String nome);

//    List<Cliente> findByNoneOrIdOrderById(String nome, Integer id);
//
//    Cliente findOneByNome(String nome);

    @Query("delete from Cliente c where c.nome = : nome")
    @Modifying
    void deleteByNome(String nome);

    boolean existsByNome(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos where c.id = :id")
    Cliente findClienteFetchPedidos(Integer id);
}
