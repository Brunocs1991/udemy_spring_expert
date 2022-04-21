package github.brunocs1991.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartConfiguration {

    @Bean
    public String applicationName(){
        return "Sistema de vendas";
    }
}
