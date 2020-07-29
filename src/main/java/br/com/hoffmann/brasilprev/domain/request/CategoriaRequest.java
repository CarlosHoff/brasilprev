package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ApiModel(value = "CategoriaRequest")
public class CategoriaRequest implements Serializable {

    @ApiModelProperty(value = "Tipo de categoria")
    @NotNull
    private String categoria;
}
