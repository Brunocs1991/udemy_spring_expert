package github.brunocs1991.jpa.domain.repository;

import github.brunocs1991.jpa.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientesRepository {

//    private static String INSERT = "insert into cliente  (nome) values(?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";
//    private static String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE ID =?";
    private static String DELETAR = "DELETE FROM cliente WHERE ID = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar(Cliente cliente) {
//        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente) {
//        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Cliente cliente) {
//        this.deletar(cliente.getId());
        if(!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }

    @Transactional
    public void deletar(Integer id) {
//        jdbcTemplate.update(DELETAR, new Object[]{id});
        Cliente cliente = entityManager.find(Cliente.class, id);
        this.deletar(cliente);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome(String nome) {
//        return jdbcTemplate.<Cliente>query(SELECT_ALL.concat(" where nome like ?"), new Object[]{"%" + nome + "%"}, obterClienteMapper());
        String jpql = "select c  from Cliente c where c.nome like :nome";
        TypedQuery<Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("nome", "%" +nome+ "%");
        return query.getResultList();

    }

    @Transactional(readOnly = true)
    public List<Cliente> obterTodos() {
//        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
        return entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }

//    private RowMapper<Cliente> obterClienteMapper() {
//        return new RowMapper<Cliente>() {
//            @Override
//            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return new Cliente(rs.getInt("id"), rs.getString("nome"));
//            }
//        };
//    }
}
