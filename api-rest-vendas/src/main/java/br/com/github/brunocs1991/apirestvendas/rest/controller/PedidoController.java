package br.com.github.brunocs1991.apirestvendas.rest.controller;

import br.com.github.brunocs1991.apirestvendas.domain.entity.Pedido;
import br.com.github.brunocs1991.apirestvendas.rest.dto.InformacoesPedidoDTO;
import br.com.github.brunocs1991.apirestvendas.rest.dto.PedidoDTO;
import br.com.github.brunocs1991.apirestvendas.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoService.salvar(pedidoDTO);
        return pedido.getId();
    }

    @GetMapping("/{id}")
    public InformacoesPedidoDTO getById(@PathVariable Integer id) {
        return pedidoService.ObterPedidoCompleto(id).map( p ->
             pedidoService.converter(p)
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }
}
