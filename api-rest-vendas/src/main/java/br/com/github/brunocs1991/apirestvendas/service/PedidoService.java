package br.com.github.brunocs1991.apirestvendas.service;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Pedido;
import br.com.github.brunocs1991.apirestvendas.domain.enums.StatusPedido;
import br.com.github.brunocs1991.apirestvendas.rest.dto.InformacoesPedidoDTO;
import br.com.github.brunocs1991.apirestvendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO pedidoDTO);
    Optional<Pedido> obterPedidoCompleto(Integer id);
   InformacoesPedidoDTO converter(Pedido pedido);
   void atualizaStatus(Integer id, StatusPedido statusPedido);
}
