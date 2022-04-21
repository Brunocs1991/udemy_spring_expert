package github.brunocs1991.service;

import github.brunocs1991.model.Cliente;
import github.brunocs1991.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository;

    public void salvarCliente(Cliente cliente){
        this.validarCliente(cliente);
        this.repository.persistir(cliente);

    }
    public void validarCliente(Cliente cliente){
        //aplica validação

    }
}
