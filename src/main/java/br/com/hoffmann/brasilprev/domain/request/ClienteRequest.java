package br.com.hoffmann.brasilprev.domain.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ApiModel(value = "ClienteRequest")
public class ClienteRequest implements Serializable {

    @ApiModelProperty(value = "Nome do cliente")
    @NotNull
    private String nome;

    @ApiModelProperty(value = "Email")
    @NotNull
    @Email
    private String email;

    @ApiModelProperty(value = "Senha")
    @NotNull
    private String senha;

    @ApiModelProperty(value = "Rua")
    @NotNull
    private String rua;

    @ApiModelProperty(value = "Cidade")
    @NotNull
    private String cidade;

    @ApiModelProperty(value = "Bairro")
    @NotNull
    private String bairro;

    @ApiModelProperty(value = "Cep")
    @NotNull
    private String cep;

    @ApiModelProperty(value = "Estado")
    @NotNull
    private String estado;
}
