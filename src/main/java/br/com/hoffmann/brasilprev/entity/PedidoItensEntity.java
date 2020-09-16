package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.request.PedidoItens;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDO_ITENS_ENTITY")
public class PedidoItensEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_PEDIDO_ITENS_ENTITY")
  @SequenceGenerator(sequenceName = "SQ_PEDIDO_ITENS_ENTITY", allocationSize = 1, name = "SQ_PEDIDO_ITENS_ENTITY")
  @Column(name = "ID")
  private Long id;

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

  public PedidoItensEntity() {
  }

  public PedidoItensEntity(ProdutosEntity produto, PedidoItens pedidoItens) {
    this.valor = produto.getPreco();
    this.subtotal = produto.getPreco() * pedidoItens.getQuantidade();
    this.quantidade = produto.getQuantidade();
    this.produto = produto.getProduto();
  }

  public PedidoItensEntity(PedidoItens pedidoItens) {
    this.produto = pedidoItens.getProduto().toString();
    this.quantidade = pedidoItens.getQuantidade();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PedidosEntity getPedidosEntity() {
    return pedidosEntity;
  }

  public void setPedidosEntity(PedidosEntity pedidosEntity) {
    this.pedidosEntity = pedidosEntity;
  }

  public List<ProdutosEntity> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<ProdutosEntity> produtos) {
    this.produtos = produtos;
  }

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public Double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Double subtotal) {
    this.subtotal = subtotal;
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
