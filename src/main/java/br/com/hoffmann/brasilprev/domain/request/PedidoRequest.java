package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
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
}
