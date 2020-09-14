package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel(value = "PedidoRequest")
public class PedidoRequest implements Serializable {

  @ApiModelProperty(value = "cliente")
  @NotNull
  private Long cliente;

  @ApiModelProperty(value = "data")
  @NotNull
  private LocalDate data;

  @ApiModelProperty(value = "Itens do pedido")
  @NotNull
  private List<PedidoItens> itensDoPedido;

  public Long getCliente() {
    return cliente;
  }

  public void setCliente(Long cliente) {
    this.cliente = cliente;
  }

  public LocalDate getData() {
    return data;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public List<PedidoItens> getItensDoPedido() {
    return itensDoPedido;
  }

  public void setItensDoPedido(
      List<PedidoItens> itensDoPedido) {
    this.itensDoPedido = itensDoPedido;
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
