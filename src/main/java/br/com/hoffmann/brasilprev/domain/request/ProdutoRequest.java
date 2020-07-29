package br.com.hoffmann.brasilprev.domain.request;

import br.com.hoffmann.brasilprev.domain.enums.BrasilPrevEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ApiModel(value = "ProdutoRequest")
public class ProdutoRequest implements Serializable {

    @ApiModelProperty(value = "cliente")
    @NotNull
    private Long cliente;

    @ApiModelProperty(value = "data")
    @NotNull
    private LocalDateTime data;

    @ApiModelProperty(value = "status")
    @NotNull
    private BrasilPrevEnum status;

    @ApiModelProperty(value = "sessao")
    @NotNull
    private String sessao;

    @ApiModelProperty(value = "Itens do pedido")
    @NotNull
    private PedidoItens pedidoItens;
}
