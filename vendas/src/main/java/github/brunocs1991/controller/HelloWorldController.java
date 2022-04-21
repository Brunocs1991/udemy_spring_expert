package github.brunocs1991.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("hello")
    public String helloWorld(){
        return "hello world";
    }
}
