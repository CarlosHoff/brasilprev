package br.com.hoffmann.brasilprev.security;

import br.com.hoffmann.brasilprev.entity.ClienteEntity;
import br.com.hoffmann.brasilprev.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class ImplementsUserDetailsService implements UserDetailsService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    UserDetails retorno = null;
    Optional<ClienteEntity> entityExample = this.clienteRepository.findOne(Example.of(ClienteEntity.from(username)));
    if (entityExample.isPresent()) {
      ClienteEntity clienteEntity = entityExample.get();
      retorno = new User(clienteEntity.getEmail(), clienteEntity.getSenha(), new ArrayList<>());
      return retorno;
    }
    return retorno;
  }
}
