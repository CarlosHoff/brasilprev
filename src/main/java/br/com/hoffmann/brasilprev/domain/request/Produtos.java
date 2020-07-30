package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ApiModel(value = "Produtos")
public class Produtos implements Serializable {

    @ApiModelProperty(value = "Produto")
    private String produto;

    @ApiModelProperty(value = "Quantidade")
    private Long quantidade;

}
