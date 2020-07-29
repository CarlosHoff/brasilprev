package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.enums.BrasilPrevEnum;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "PEDIDOS")
@Entity
public class PedidosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PEDIDOS")
    @SequenceGenerator(sequenceName = "SQ_PEDIDOS", allocationSize = 1, name = "SQ_PEDIDOS")
    @Column(name = "ID_PEDIDO")
    private Long idPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity clienteEntity;

    @Column(name = "DATA")
    private LocalDate data;

    @Column(name = "STATUS")
    private BrasilPrevEnum status;

    @Column(name = "SESSAO")
    private String sessao;

}
