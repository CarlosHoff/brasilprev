package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.request.CategoriaRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "CATEGORIA")
@Entity
public class CategoriaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA")
  @SequenceGenerator(sequenceName = "SQ_CATEGORIA", allocationSize = 1, name = "SQ_CATEGORIA")
  @Column(name = "ID_CATEGORIA")
  private Long idCategoria;

  @Column(name = "CATEGORIA", nullable = false)
  private String categoria;

  public CategoriaEntity(CategoriaRequest request) {
    this.categoria = request.getCategoria();
  }

  public CategoriaEntity() {
  }

  public Long getIdCategoria() {
    return idCategoria;
  }

  public void setIdCategoria(Long idCategoria) {
    this.idCategoria = idCategoria;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
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
