package github.brunocs1991.jpa;

import github.brunocs1991.jpa.domain.entity.Cliente;
import github.brunocs1991.jpa.domain.entity.Pedido;
import github.brunocs1991.jpa.domain.repository.ClientesRepository;
import github.brunocs1991.jpa.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(@Autowired ClientesRepository clientesRepository, @Autowired PedidoRepository pedidoRepository) {
        return args -> {

            Cliente cliente = new Cliente();
            cliente.setNome("Bruno");
            clientesRepository.save(cliente);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Costa");
            clientesRepository.save(cliente2);

            Pedido p = new Pedido();
            p.setCliente(cliente);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidoRepository.save(p);
            Cliente tmp = clientesRepository.findClienteFetchPedidos(cliente.getId());
            System.out.println(tmp);
            System.out.println(tmp.getPedidos());

            System.out.println(pedidoRepository.findByCliente(cliente));

/*
            boolean existe = clientesRepository.existsByNome("Bruno");
            System.out.println("Existe um cliente com nome bruno? " + existe);

            List<Cliente> todos = clientesRepository.encontrarPorNome("Bruno");
            todos.forEach(System.out::println);


            System.out.println("Atualizando");
            todos.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientesRepository.save(c);
            });

            todos = clientesRepository.findAll();
            todos.forEach(System.out::println);

            System.out.println("Filtrando");
            clientesRepository.findByNomeLike("b").forEach(System.out::println);

            System.out.println("Deletando");
            clientesRepository.findAll().forEach(c -> clientesRepository.delete(c));
            todos = clientesRepository.findAll();
            if (todos.isEmpty()) {
                System.out.println("Nenhum Cliente encontrado");
            } else {
                todos.forEach(System.out::println);
            }
            */

        };
    }

}
