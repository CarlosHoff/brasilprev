package br.com.hoffmann.brasilprev.domain.response;

import br.com.hoffmann.brasilprev.entity.PedidoItensEntity;
import br.com.hoffmann.brasilprev.entity.PedidosEntity;
import br.com.hoffmann.brasilprev.entity.ProdutosEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;

@ApiModel(value = "PedidoResponse")
public class PedidoResponse implements Serializable {

  @ApiModelProperty(value = "idPedidoItens")
  private Long idPedidoItens;

  @ApiModelProperty(value = "pedidosEntity")
  private PedidosEntity pedidosEntity;

  @ApiModelProperty(value = "produtos")
  private List<ProdutosEntity> produtos;

  @ApiModelProperty(value = "produto")
  private String produto;

  @ApiModelProperty(value = "quantidade")
  private Long quantidade;

  @ApiModelProperty(value = "valor")
  private Double valor;

  @ApiModelProperty(value = "subtotal")
  private Double subtotal;

  public PedidoResponse() {
  }

  public PedidoResponse(PedidoItensEntity pedidoItensEntity) {
    this.idPedidoItens = pedidoItensEntity.getId();
    this.pedidosEntity = pedidoItensEntity.getPedidosEntity();
    this.produtos = pedidoItensEntity.getProdutos();
    this.produto = pedidoItensEntity.getProduto();
    this.quantidade = pedidoItensEntity.getQuantidade();
    this.valor = pedidoItensEntity.getValor();
    this.subtotal = pedidoItensEntity.getSubtotal();
  }

  public Long getIdPedidoItens() {
    return idPedidoItens;
  }

  public void setIdPedidoItens(Long idPedidoItens) {
    this.idPedidoItens = idPedidoItens;
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
