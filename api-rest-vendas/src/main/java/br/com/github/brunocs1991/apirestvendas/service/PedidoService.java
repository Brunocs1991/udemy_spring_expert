package br.com.github.brunocs1991.apirestvendas.service;

import br.com.github.brunocs1991.apirestvendas.domain.entity.ItemPedido;
import br.com.github.brunocs1991.apirestvendas.domain.entity.Pedido;
import br.com.github.brunocs1991.apirestvendas.rest.dto.InformacaoItemPedidoDTO;
import br.com.github.brunocs1991.apirestvendas.rest.dto.InformacoesPedidoDTO;
import br.com.github.brunocs1991.apirestvendas.rest.dto.PedidoDTO;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO pedidoDTO);
    Optional<Pedido> ObterPedidoCompleto(Integer id);

   InformacoesPedidoDTO converter(Pedido pedido);
}
