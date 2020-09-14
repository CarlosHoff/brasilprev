package br.com.hoffmann.brasilprev.service;

import static java.lang.String.format;

import br.com.hoffmann.brasilprev.domain.request.PedidoItens;
import br.com.hoffmann.brasilprev.domain.request.PedidoRequest;
import br.com.hoffmann.brasilprev.domain.response.PedidoResponse;
import br.com.hoffmann.brasilprev.entity.ClienteEntity;
import br.com.hoffmann.brasilprev.entity.PedidoItensEntity;
import br.com.hoffmann.brasilprev.entity.PedidosEntity;
import br.com.hoffmann.brasilprev.entity.ProdutosEntity;
import br.com.hoffmann.brasilprev.repository.CategoriaRepository;
import br.com.hoffmann.brasilprev.repository.PedidoItensRepository;
import br.com.hoffmann.brasilprev.repository.PedidosRepository;
import br.com.hoffmann.brasilprev.repository.ProdutosRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "transactionManager")
public class PedidoService extends BrasilPrevService {

  @Autowired
  private PedidoItensRepository pedidoItensRepository;

  @Autowired
  private PedidosRepository pedidosRepository;

  @Autowired
  private ProdutosRepository produtosRepository;

  @Autowired
  private CategoriaRepository categoriaRepository;

  public void cadastraPedido(PedidoRequest request) throws NotFoundException {

    ClienteEntity cliente = getCliente(request);

    PedidosEntity pedidos = new PedidosEntity();
    pedidos.setClienteEntity(cliente);
    PedidosEntity pedidoSalvo = pedidosRepository.save(pedidos);

    List<PedidoItensEntity> listItens = new ArrayList<>();
    for (PedidoItens pedidoItens : request.getItensDoPedido()) {
      Optional<ProdutosEntity> produtos = produtosRepository.findById(pedidoItens.getProduto());
      if (!produtos.isPresent()) {
        throw new NotFoundException(
            String.format("Produto [%s] não existe na base", pedidoItens.getProduto()));
      }
      ProdutosEntity produto = produtos.get();
      PedidoItensEntity pedido = new PedidoItensEntity(produto, pedidoItens);
      pedido.setPedidosEntity(pedidoSalvo);
      listItens.add(pedido);
    }
    pedidoItensRepository.saveAll(listItens);
  }

  public void deletaPedido(Long id) { pedidosRepository.deleteById(id); }

  public List<PedidoResponse> buscaPedidos() {
    List<PedidoItensEntity> pedidos = pedidoItensRepository.findAll();
    return pedidos.stream().map(PedidoResponse::new).collect(Collectors.toList());
  }

  public PedidoResponse buscaPedidoPeloID(Long id) throws NotFoundException {
    Optional<PedidoItensEntity> produto = pedidoItensRepository.findById(id);
    if (!produto.isPresent()) {
      throw new NotFoundException(format("Produto com i ID: [%s] não foi encontrado", id));
    }
    return new PedidoResponse(produto.get());
  }
}
