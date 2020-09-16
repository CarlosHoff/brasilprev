package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTOS_ENTITY")
public class ProdutosEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SQ_PRODUTOS_ENTITY")
  @SequenceGenerator(sequenceName = "SQ_PRODUTOS_ENTITY", allocationSize = 1, name = "SQ_PRODUTOS_ENTITY")
  @Column(name = "ID")
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ID_CATEGORIA")
  private CategoriaEntity categoriaEntity;

  @Column(name = "PRODUTO", nullable = false)
  private String produto;

  @Column(name = "PRECO", nullable = false)
  private Double preco;

  @Column(name = "QUANTIDADE", nullable = false)
  private Long quantidade;

  @Column(name = "DESCRICAO", nullable = false)
  private String descricao;

  @Lob
  @Column(name = "FOTO", nullable = false)
  private byte[] foto;

  public ProdutosEntity() {
  }

  public ProdutosEntity(ProdutoRequest request) {
    this.produto = request.getProduto();
    this.preco = request.getPreco();
    this.quantidade = request.getQuantidade();
    this.descricao = request.getDescricao();
    this.foto = request.getFoto();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
