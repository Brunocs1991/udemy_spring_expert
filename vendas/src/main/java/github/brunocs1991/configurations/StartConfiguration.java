package github.brunocs1991.configurations;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development")
public class StartConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return  args -> {
            System.out.println("rodando configuração de desenvolvimento");
        };
    }
}
