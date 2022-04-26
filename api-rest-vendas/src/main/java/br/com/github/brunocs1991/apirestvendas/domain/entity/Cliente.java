package br.com.github.brunocs1991.apirestvendas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(name = "cpf", length = 11)
    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Pedido> pedidos;
}
