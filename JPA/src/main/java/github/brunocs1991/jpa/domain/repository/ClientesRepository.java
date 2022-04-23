package github.brunocs1991.jpa.domain.repository;

import github.brunocs1991.jpa.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findByNomeLike(String nome);

//    List<Cliente> findByNoneOrIdOrderById(String nome, Integer id);
//
//    Cliente findOneByNome(String nome);

    boolean existsByNome(String nome);
}
