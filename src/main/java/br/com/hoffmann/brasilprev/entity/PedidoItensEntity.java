package br.com.hoffmann.brasilprev.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "PEDIDO_ITENS")
@Entity
public class PedidoItensEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PEDIDO_ITENS")
    @SequenceGenerator(sequenceName = "SQ_PEDIDO_ITENS", allocationSize = 1, name = "SQ_PEDIDO_ITENS")
    @Column(name = "ID_PEDIDO_ITENS")
    private Long idPedidoItens;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO")
    private PedidosEntity pedidosEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUTOS")
    private List<ProdutosEntity> produtos;

    @Column(name = "PRODUTO")
    private String produto;

    @Column(name = "QUANTIDADE")
    private Long quantidade;

    @Column(name = "VALOR")
    private Double valor;

    @Column(name = "SUBTOTAL")
    private Double subtotal;
}
