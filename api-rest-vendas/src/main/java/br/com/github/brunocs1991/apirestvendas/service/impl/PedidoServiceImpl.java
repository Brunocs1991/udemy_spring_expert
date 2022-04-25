package br.com.github.brunocs1991.apirestvendas.service.impl;

import br.com.github.brunocs1991.apirestvendas.domain.repository.PedidoRepository;
import br.com.github.brunocs1991.apirestvendas.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
    private PedidoRepository pedidoRepository;

    public  PedidoServiceImpl(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }
}
