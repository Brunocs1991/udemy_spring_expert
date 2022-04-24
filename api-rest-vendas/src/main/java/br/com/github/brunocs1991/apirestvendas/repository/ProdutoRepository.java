package br.com.github.brunocs1991.apirestvendas.repository;
import br.com.github.brunocs1991.apirestvendas.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
