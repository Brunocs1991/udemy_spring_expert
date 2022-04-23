package github.brunocs1991.jpa.domain.repository;

import github.brunocs1991.jpa.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
