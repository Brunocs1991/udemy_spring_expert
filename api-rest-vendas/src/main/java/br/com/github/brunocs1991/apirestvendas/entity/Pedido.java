package br.com.github.brunocs1991.apirestvendas.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @Column(name = "total", scale = 2, precision = 20)
    private BigDecimal total;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens;

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", dataPedido=" + dataPedido +
                ", total=" + total +
                '}';
    }
}
