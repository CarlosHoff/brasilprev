package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.enums.BrasilPrevEnum;
import java.time.LocalDate;
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

  public PedidosEntity() {
    this.data = LocalDate.now();
    this.status = BrasilPrevEnum.ANALISE;
    this.sessao = "JOGOS";
  }

  public Long getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(Long idPedido) {
    this.idPedido = idPedido;
  }

  public ClienteEntity getClienteEntity() {
    return clienteEntity;
  }

  public void setClienteEntity(ClienteEntity clienteEntity) {
    this.clienteEntity = clienteEntity;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public BrasilPrevEnum getStatus() {
    return status;
  }

  public void setStatus(BrasilPrevEnum status) {
    this.status = status;
  }

  public String getSessao() {
    return sessao;
  }

  public void setSessao(String sessao) {
    this.sessao = sessao;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

}
