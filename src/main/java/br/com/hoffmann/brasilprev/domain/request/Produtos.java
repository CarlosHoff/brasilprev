package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@ApiModel(value = "Produtos")
public class Produtos {

    @ApiModelProperty(value = "Categoria")
    private Categoria categoria;

    @ApiModelProperty(value = "Produto")
    private String produto;

    @ApiModelProperty(value = "Preco")
    private Double preco;

    @ApiModelProperty(value = "Quantidade")
    private Long quantidade;

    @ApiModelProperty(value = "Descricao")
    private String descricao;

    @ApiModelProperty(value = "Foto")
    private byte[] foto;
}
