package github.brunocs1991.configurations;

import github.brunocs1991.anotations.Development;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class StartConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return  args -> {
            System.out.println("rodando configuração de desenvolvimento");
        };
    }
}
