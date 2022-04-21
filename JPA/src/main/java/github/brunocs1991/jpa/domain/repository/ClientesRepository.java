package github.brunocs1991.jpa.domain.repository;

import github.brunocs1991.jpa.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClientesRepository {

    private static String INSERT = "insert into cliente  (nome) values(?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";
    private static String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE ID =?";
    private static String DELETAR = "DELETE FROM cliente WHERE ID = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Cliente salvar(Cliente cliente) {
        jdbcTemplate.update(INSERT, new Object[]{cliente.getNome()});
        return cliente;
    }

    public Cliente atualizar(Cliente cliente) {
        jdbcTemplate.update(UPDATE, new Object[]{cliente.getNome(), cliente.getId()});
        return cliente;
    }

    public void deletar(Cliente cliente) {
        this.deletar(cliente.getId());
    }

    public void deletar(Integer id) {
        jdbcTemplate.update(DELETAR, new Object[]{id});
    }

    public List<Cliente> buscarPorNome(String nome) {
        return jdbcTemplate.<Cliente>query(SELECT_ALL.concat(" where nome like ?"), new Object[]{"%" + nome + "%"}, obterClienteMapper());
    }

    public List<Cliente> obterTodos() {
        return jdbcTemplate.query(SELECT_ALL, obterClienteMapper());
    }

    private RowMapper<Cliente> obterClienteMapper() {
        return new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Cliente(rs.getInt("id"), rs.getString("nome"));
            }
        };
    }
}
