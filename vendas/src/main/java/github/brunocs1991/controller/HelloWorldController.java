package github.brunocs1991.controller;

import github.brunocs1991.configurations.StartConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @GetMapping("hello")
    public String helloWorld(){
        return applicationName;
    }
}
