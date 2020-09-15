package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.request.ClienteRequest;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class ClienteEntity implements UserDetails {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "NOME", nullable = false)
  private String nome;

  @Column(name = "EMAIL", nullable = false)
  private String email;

  @Column(name = "SENHA", nullable = false)
  private String senha;

  @Column(name = "RUA", nullable = false)
  private String rua;

  @Column(name = "CIDADE", nullable = false)
  private String cidade;

  @Column(name = "BAIRRO", nullable = false)
  private String bairro;

  @Column(name = "CEP", nullable = false)
  private String cep;

  @Column(name = "ESTADO", nullable = false)
  private String estado;

  private ClienteEntity(String email) {
    this.email = email;
    id = null;
    senha = null;
  }

  public ClienteEntity() {
  }

  public ClienteEntity(Long id, String email, String senha) {
    this.id = id;
    this.email = email;
    this.senha = senha;
  }

  public static ClienteEntity from(String email) {
    return  new ClienteEntity(email);
  }

  public ClienteEntity(ClienteRequest request) {
    this.nome = request.getNome();
    this.email = request.getEmail();
    this.rua = request.getRua();
    this.cidade = request.getCidade();
    this.bairro = request.getBairro();
    this.cep = request.getCep();
    this.estado = request.getEstado();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return this.senha;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
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
