package br.com.hoffmann.brasilprev.service;

import br.com.hoffmann.brasilprev.domain.request.PedidoRequest;
import br.com.hoffmann.brasilprev.entity.ClienteEntity;
import br.com.hoffmann.brasilprev.repository.ClienteRepository;
import java.util.Optional;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BrasilPrevService {

  @Autowired
  private ClienteRepository clienteRepository;

  public ClienteEntity getCliente(PedidoRequest request) throws NotFoundException {
    Optional<ClienteEntity> cliente = clienteRepository.findById(request.getCliente());
    if (!cliente.isPresent()) {
      throw new NotFoundException(
          String.format("Cliente [%s] não cadastrado", cliente.get().getNome()));
    }
    return cliente.get();
  }
}
