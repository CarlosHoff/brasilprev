package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ApiModel(value = "PedidoItens")
public class PedidoItens {

    @ApiModelProperty(value = "Produtos")
    private List<Produtos> produtosList;

    @ApiModelProperty(value = "Produto")
    private String produto;

    @ApiModelProperty(value = "Quantidade")
    private Long quantidade;

    @ApiModelProperty(value = "Valor")
    private Double valor;

    @ApiModelProperty(value = "Subtotal")
    private Double subtotal;
}
