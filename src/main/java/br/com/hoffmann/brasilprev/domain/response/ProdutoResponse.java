package br.com.hoffmann.brasilprev.domain.response;

import br.com.hoffmann.brasilprev.entity.CategoriaEntity;
import br.com.hoffmann.brasilprev.entity.ProdutosEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "ProdutoResponse")
public class ProdutoResponse implements Serializable {

  @ApiModelProperty(value = "idProdutos")
  private Long idProdutos;

  @ApiModelProperty(value = "categoriaEntity")
  private CategoriaEntity categoriaEntity;

  @ApiModelProperty(value = "produto")
  private String produto;

  @ApiModelProperty(value = "preco")
  private Double preco;

  @ApiModelProperty(value = "quantidade")
  private Long quantidade;

  @ApiModelProperty(value = "descricao")
  private String descricao;

  @ApiModelProperty(value = "foto")
  private byte[] foto;

  public ProdutoResponse() {
  }

  public ProdutoResponse(ProdutosEntity produtosEntity) {
    this.idProdutos = produtosEntity.getIdProdutos();
    this.produto = produtosEntity.getProduto();
    this.preco = produtosEntity.getPreco();
    this.quantidade = produtosEntity.getQuantidade();
    this.descricao = produtosEntity.getDescricao();
    this.foto = produtosEntity.getFoto();
  }

  public Long getIdProdutos() {
    return idProdutos;
  }

  public void setIdProdutos(Long idProdutos) {
    this.idProdutos = idProdutos;
  }

  public CategoriaEntity getCategoriaEntity() {
    return categoriaEntity;
  }

  public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
    this.categoriaEntity = categoriaEntity;
  }

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
