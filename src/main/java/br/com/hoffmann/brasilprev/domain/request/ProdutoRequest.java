package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ProdutoRequest")
public class ProdutoRequest {

  @ApiModelProperty(value = "produto")
  @NotNull
  private String produto;

  @ApiModelProperty(value = "preco")
  @NotNull
  private Double preco;

  @ApiModelProperty(value = "quantidade")
  @NotNull
  private Long quantidade;

  @ApiModelProperty(value = "descricao")
  @NotNull
  private String descricao;

  @ApiModelProperty(value = "foto")
  private byte[] foto;

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public Long getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Long quantidade) {
    this.quantidade = quantidade;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public byte[] getFoto() {
    return foto;
  }

  public void setFoto(byte[] foto) {
    this.foto = foto;
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
