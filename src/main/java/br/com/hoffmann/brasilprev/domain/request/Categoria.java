package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;

@ApiModel(value = "Categoria")
public class Categoria implements Serializable {

  private String categoria;

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
