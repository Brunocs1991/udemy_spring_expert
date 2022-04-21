package github.brunocs1991.controller;

import github.brunocs1991.anotations.Cachorro;
import github.brunocs1991.anotations.Gato;
import github.brunocs1991.configurations.StartConfiguration;
import github.brunocs1991.interfaces.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${application.name}")
    private String applicationName;

    @Cachorro
    private Animal aninal;

    @Bean(name = "executar animal")
    public CommandLineRunner executar(){
        return args -> {
            this.aninal.fazerBarulho();
        };
    }
    @GetMapping("hello")
    public String helloWorld(){
        return applicationName;
    }
}
