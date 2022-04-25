package br.com.github.brunocs1991.apirestvendas.service;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Pedido;
import br.com.github.brunocs1991.apirestvendas.rest.dto.PedidoDTO;
import org.springframework.stereotype.Service;

public interface PedidoService {
    Pedido salvar(PedidoDTO pedidoDTO);
}
