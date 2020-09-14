package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

@ApiModel(value = "PedidoItens")
public class PedidoItens implements Serializable {

  @ApiModelProperty(value = "produto")
  @NotNull
  private Long produto;

  @ApiModelProperty(value = "quantidade")
  @NotNull
  private Long quantidade;

  public Long getProduto() {
    return produto;
  }

  public void setProduto(Long produto) {
    this.produto = produto;
  }

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
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
