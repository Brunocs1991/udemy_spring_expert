package br.com.github.brunocs1991.apirestvendas.rest.dto;

import br.com.github.brunocs1991.apirestvendas.validation.NotEmptyList;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private Integer cliente;
    @NotNull(message = "{campo.total-pedido.obrigatorio}")
    private BigDecimal total;
    @NotEmptyList( message = "{campo.items-pedido.obrigatorio}")
    private List<ItemPedidoDTO> itens;
}
