package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.enums.BrasilPrevEnum;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOS_ENTITY")
public class PedidosEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_PEDIDOS_ENTITY")
  @SequenceGenerator(sequenceName = "SQ_PEDIDOS_ENTITY", allocationSize = 1, name = "SQ_PEDIDOS_ENTITY")
  @Column(name = "ID")
  private Long id;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
