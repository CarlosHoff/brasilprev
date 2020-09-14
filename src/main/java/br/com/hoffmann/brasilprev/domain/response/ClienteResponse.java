package br.com.hoffmann.brasilprev.domain.response;

import br.com.hoffmann.brasilprev.entity.ClienteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel(value = "ClienteResponse")
public class ClienteResponse implements Serializable {

  @ApiModelProperty(value = "idCliente")
  private Long idCliente;

  @ApiModelProperty(value = "nome")
  private String nome;

  @ApiModelProperty(value = "email")
  private String email;

  @ApiModelProperty(value = "senha")
  private String senha;

  @ApiModelProperty(value = "rua")
  private String rua;

  @ApiModelProperty(value = "cidade")
  private String cidade;

  @ApiModelProperty(value = "bairro")
  private String bairro;

  @ApiModelProperty(value = "cep")
  private String cep;

  @ApiModelProperty(value = "estado")
  private String estado;

  public ClienteResponse() {
  }

  public ClienteResponse(ClienteEntity clienteEntity) {
    this.idCliente = clienteEntity.getIdCliente();
    this.nome = clienteEntity.getNome();
    this.email = clienteEntity.getEmail();
    this.senha = clienteEntity.getSenha();
    this.rua = clienteEntity.getRua();
    this.cidade = clienteEntity.getCidade();
    this.bairro = clienteEntity.getBairro();
    this.cep = clienteEntity.getCep();
    this.estado = clienteEntity.getEstado();
  }

  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
