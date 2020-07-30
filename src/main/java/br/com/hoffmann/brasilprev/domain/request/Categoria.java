package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ApiModel(value = "Categoria")
public class Categoria implements Serializable {

    private String categoria;
}
