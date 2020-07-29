package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.request.ClienteRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Collection;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "CLIENTE")
@Entity
public class ClienteEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CLIENTE")
    @SequenceGenerator(sequenceName = "SQ_CLIENTE", allocationSize = 1, name = "SQ_CLIENTE")
    @Column(name = "ID_CLIENTE")
    private Long idCliente;

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

    public ClienteEntity() {
    }

    public ClienteEntity(ClienteRequest request) {
        this.nome = request.getNome();
        this.email = request.getEmail();
        this.senha = request.getSenha();
        this.rua = request.getRua();
        this.cidade = request.getCidade();
        this.bairro = request.getBairro();
        this.cep = request.getCep();
        this.estado = request.getEstado();
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
}
