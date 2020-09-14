package br.com.hoffmann.brasilprev.service;

import static java.lang.String.format;

import br.com.hoffmann.brasilprev.domain.request.ClienteRequest;
import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
import br.com.hoffmann.brasilprev.domain.response.ClienteResponse;
import br.com.hoffmann.brasilprev.entity.ClienteEntity;
import br.com.hoffmann.brasilprev.repository.CategoriaRepository;
import br.com.hoffmann.brasilprev.repository.ClienteRepository;
import br.com.hoffmann.brasilprev.repository.PedidoItensRepository;
import br.com.hoffmann.brasilprev.repository.PedidosRepository;
import br.com.hoffmann.brasilprev.repository.ProdutosRepository;
import br.com.hoffmann.brasilprev.utils.CriptografiaUtils;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "transactionManager")
public class ClienteService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private PedidoItensRepository pedidoItensRepository;

  @Autowired
  private PedidosRepository pedidosRepository;

  @Autowired
  private ProdutosRepository produtosRepository;

  @Autowired
  private CriptografiaUtils criptografiaUtils;

  public void cadastraCliente(ClienteRequest request) {
    ClienteEntity clienteEntity = new ClienteEntity(request);
    clienteEntity.setSenha(this.criptografiaUtils.encode(request.getSenha()));
    clienteRepository.save(clienteEntity);
  }

  public void deletaCliente(Long id) {
    clienteRepository.deleteById(id);
  }

  public List<ClienteResponse> buscaClientes() {
    List<ClienteEntity> cliente = clienteRepository.findAll();
    return cliente.stream().map(ClienteResponse::new).collect(Collectors.toList());
  }


  public ClienteResponse buscaClientePeloID(Long id) throws NotFoundException {
    Optional<ClienteEntity> cliente = clienteRepository.findById(id);
    if (!cliente.isPresent()) {
      throw new NotFoundException(format("Cliente: [%s] não foi encontrado", id));
    }
    return new ClienteResponse(cliente.get());
  }
}
