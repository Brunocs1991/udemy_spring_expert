package br.com.github.brunocs1991.apirestvendas.rest.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    @NotNull(message = "Informe o código do cliente")
    private Integer cliente;
    @NotNull(message = "Campo Total do pedido e obrigatorio")
    private BigDecimal total;
    private List<ItemPedidoDTO> itens;
}
