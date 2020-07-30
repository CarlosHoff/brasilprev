package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode
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
}
