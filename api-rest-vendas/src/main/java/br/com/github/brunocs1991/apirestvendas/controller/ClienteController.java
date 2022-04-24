package br.com.github.brunocs1991.apirestvendas.controller;

import br.com.github.brunocs1991.apirestvendas.entity.Cliente;
import br.com.github.brunocs1991.apirestvendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getClienteById( @PathVariable Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity save (@RequestBody Cliente cliente){
        Cliente clienteSalvo =  clienteRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }
}
