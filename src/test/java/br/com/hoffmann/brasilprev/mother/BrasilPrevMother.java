package br.com.hoffmann.brasilprev.mother;

import br.com.hoffmann.brasilprev.domain.enums.BrasilPrevEnum;
import br.com.hoffmann.brasilprev.domain.request.CategoriaRequest;
import br.com.hoffmann.brasilprev.domain.request.ClienteRequest;
import br.com.hoffmann.brasilprev.domain.request.PedidoItens;
import br.com.hoffmann.brasilprev.domain.request.PedidoRequest;
import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
import br.com.hoffmann.brasilprev.domain.response.ClienteResponse;
import br.com.hoffmann.brasilprev.entity.CategoriaEntity;
import br.com.hoffmann.brasilprev.entity.ClienteEntity;
import br.com.hoffmann.brasilprev.entity.PedidoItensEntity;
import br.com.hoffmann.brasilprev.entity.PedidosEntity;
import br.com.hoffmann.brasilprev.entity.ProdutosEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BrasilPrevMother {

  public static final String V1_BRASILPREV = "/v1/brasilprev";

  public static ProdutosEntity createProdutosEntity() {
    ProdutosEntity produtosEntity = new ProdutosEntity();
    produtosEntity.setId(1L);
    produtosEntity.setProduto("produto");
    produtosEntity.setQuantidade(10L);
    produtosEntity.setPreco(25.50);
    produtosEntity.setDescricao("descricao");
    produtosEntity.setCategoriaEntity(createCategoriaEntity());
    return produtosEntity;
  }

  public static ProdutoRequest createProdutosRequest() {
    ProdutoRequest request = new ProdutoRequest();
    request.setProduto("produto");
    request.setQuantidade(10L);
    request.setPreco(25.50);
    request.setDescricao("descricao");
    return request;
  }

  public static CategoriaEntity createCategoriaEntity() {
    CategoriaEntity categoriaEntity = new CategoriaEntity();
    categoriaEntity.setId(1L);
    categoriaEntity.setCategoria("JOGOS");
    return categoriaEntity;
  }

  public static PedidoRequest createPedidoRequest() {
    PedidoRequest request = new PedidoRequest();
    request.setCliente(1L);
    request.setData(LocalDate.now());
    request.setItensDoPedido(createPedidoItens());
    return request;
  }

  private static List<PedidoItens> createPedidoItens() {
    List<PedidoItens> pedidoItensEntityList = new ArrayList<>();
    PedidoItens itens = new PedidoItens();
    itens.setProduto(1L);
    itens.setQuantidade(10L);
    pedidoItensEntityList.add(itens);

    return pedidoItensEntityList;

  }

  public static CategoriaRequest createCategoriaRequest() {
    CategoriaRequest request = new CategoriaRequest();
    request.setCategoria("JOGOS");
    return request;
  }

  public static List<PedidoItensEntity> createItensEntityList(){
    List<PedidoItensEntity> pedidoItensEntityList = new ArrayList<>();
    PedidoItensEntity pedidoItensEntity = new PedidoItensEntity();
    pedidoItensEntity.setId(1L);
    pedidoItensEntity.setProduto("Bola");
    pedidoItensEntity.setValor(25.50);
    pedidoItensEntity.setSubtotal(9999.10);
    pedidoItensEntity.setQuantidade(25L);
    pedidoItensEntity.setPedidosEntity(createPedidosEntity());
    pedidoItensEntityList.add(pedidoItensEntity);
    return pedidoItensEntityList;
  }

  public static PedidosEntity createPedidosEntity() {
    PedidosEntity pedidosEntity = new PedidosEntity();
    pedidosEntity.setId(1L);
    pedidosEntity.setClienteEntity(createClienteEntity());
    pedidosEntity.setData(LocalDate.now());
    pedidosEntity.setSessao("session");
    pedidosEntity.setStatus(BrasilPrevEnum.ANALISE);
    return pedidosEntity;
  }

  public static ClienteEntity createClienteEntity() {
    ClienteEntity clienteEntity = new ClienteEntity();
    clienteEntity.setBairro("bairro");
    clienteEntity.setSenha("123456");
    clienteEntity.setCep("06033150");
    clienteEntity.setCidade("cidade");
    clienteEntity.setEmail("email@email.com");
    clienteEntity.setEstado("Sao Paulo");
    clienteEntity.setNome("nome");
    clienteEntity.setRua("rua");
    return clienteEntity;
  }

  public static ClienteRequest clienteRequest() {
    ClienteRequest request = new ClienteRequest();
    request.setBairro("bairro");
    request.setSenha("123456");
    request.setCep("06033150");
    request.setCidade("cidade");
    request.setEmail("email@email.com");
    request.setEstado("Sao Paulo");
    request.setNome("nome");
    request.setRua("rua");
    return request;
  }

}
