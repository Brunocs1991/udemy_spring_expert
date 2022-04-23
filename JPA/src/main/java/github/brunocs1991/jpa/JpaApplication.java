package github.brunocs1991.jpa;

import github.brunocs1991.jpa.domain.entity.Cliente;
import github.brunocs1991.jpa.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    CommandLineRunner init(@Autowired ClientesRepository clientesRepository) {
        return args -> {
            System.out.println("salvando");
            Cliente cliente = new Cliente();
            cliente.setNome("Bruno");
            clientesRepository.save(cliente);

            Cliente cliente2 = new Cliente();
            cliente2.setNome("Costa");
            clientesRepository.save(cliente2);
            System.out.println("Listando todos");
            List<Cliente> todos = clientesRepository.findAll();
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
        };
    }

}
