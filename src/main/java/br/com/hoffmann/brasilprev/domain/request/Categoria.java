package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@ApiModel(value = "Categoria")
public class Categoria {

    private String categoria;
}
