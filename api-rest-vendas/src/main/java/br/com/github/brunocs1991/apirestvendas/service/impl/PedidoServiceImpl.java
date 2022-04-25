package br.com.github.brunocs1991.apirestvendas.service.impl;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Cliente;
import br.com.github.brunocs1991.apirestvendas.domain.entity.ItemPedido;
import br.com.github.brunocs1991.apirestvendas.domain.entity.Pedido;
import br.com.github.brunocs1991.apirestvendas.domain.entity.Produto;
import br.com.github.brunocs1991.apirestvendas.domain.enums.StatusPedido;
import br.com.github.brunocs1991.apirestvendas.domain.repository.ClienteRepository;
import br.com.github.brunocs1991.apirestvendas.domain.repository.ItemPedidoRepository;
import br.com.github.brunocs1991.apirestvendas.domain.repository.PedidoRepository;
import br.com.github.brunocs1991.apirestvendas.domain.repository.ProdutoRepository;
import br.com.github.brunocs1991.apirestvendas.exception.RegraNegocioException;
import br.com.github.brunocs1991.apirestvendas.rest.dto.InformacaoItemPedidoDTO;
import br.com.github.brunocs1991.apirestvendas.rest.dto.InformacoesPedidoDTO;
import br.com.github.brunocs1991.apirestvendas.rest.dto.ItemPedidoDTO;
import br.com.github.brunocs1991.apirestvendas.rest.dto.PedidoDTO;
import br.com.github.brunocs1991.apirestvendas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemPedidoRepository itemPedidoRepository;


    @Override
    @Transactional
    public Pedido salvar(PedidoDTO pedidoDTO) {
        Cliente cliente = clienteRepository.findById(pedidoDTO.getCliente()).orElseThrow(() -> new RegraNegocioException("Código de cliente inválido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);
        List<ItemPedido> itemPedidos = this.converterItems(pedido, pedidoDTO.getItens());
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itemPedidos);
        pedido.setItens(itemPedidos);
        return pedido;
    }

    @Override
    public Optional<Pedido> ObterPedidoCompleto(Integer id) {
        return pedidoRepository.findByIdFetchItens(id);
    }

    @Override
    public InformacoesPedidoDTO converter(Pedido pedido) {
        return InformacoesPedidoDTO
                .builder()
                .codigo(pedido.getId())
                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(pedido.getCliente().getCpf())
                .nomeCliente(pedido.getCliente().getNome())
                .total(pedido.getTotal())
                .status(pedido.getStatus().name())
                .items(this.converter(pedido.getItens()))
                .build();
    }

    private List<InformacaoItemPedidoDTO> converter(List<ItemPedido> items) {
        if (CollectionUtils.isEmpty(items)) {
            return Collections.emptyList();
        }

        return items.stream().map(item -> InformacaoItemPedidoDTO
                .builder()
                .descricaoProduto(item.getProduto().getDescricao())
                .precoUnitario(item.getProduto().getPreco())
                .quantidade(item.getQuantidade())
                .build()
        ).collect(Collectors.toList());
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não é possivel realizar um pedido sem items.");
        }

        return items.stream().map(dto -> {
            Produto produto = produtoRepository.findById(dto.getProduto()).orElseThrow(() -> new RegraNegocioException("Código de produto inválido: " + dto.getProduto()));
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            return itemPedido;
        }).collect(Collectors.toList());
    }
}
