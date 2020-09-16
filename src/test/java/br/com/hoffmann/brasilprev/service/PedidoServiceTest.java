package br.com.hoffmann.brasilprev.service;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createClienteEntity;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createItensEntityList;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createPedidoRequest;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createPedidosEntity;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createProdutosEntity;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

import br.com.hoffmann.brasilprev.domain.response.PedidoResponse;
import br.com.hoffmann.brasilprev.repository.ClienteRepository;
import br.com.hoffmann.brasilprev.repository.PedidoItensRepository;
import br.com.hoffmann.brasilprev.repository.PedidosRepository;
import br.com.hoffmann.brasilprev.repository.ProdutosRepository;
import java.util.List;
import java.util.Optional;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PedidoServiceTest {

  @InjectMocks
  private PedidoService service;

  @Mock
  private ClienteRepository clienteRepository;

  @Mock
  private PedidosRepository pedidosRepository;

  @Mock
  private ProdutosRepository produtosRepository;

  @Mock
  private PedidoItensRepository pedidoItensRepository;

  @Before
  public void createMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void cadastraPedidoTest() throws NotFoundException {
    when(clienteRepository.findById(anyLong())).thenReturn(Optional.of(createClienteEntity()));
    when(pedidosRepository.save(createPedidosEntity())).thenReturn(createPedidosEntity());
    when(produtosRepository.findById(anyLong())).thenReturn(Optional.of(createProdutosEntity()));
    when(pedidoItensRepository.saveAll(anyList())).thenReturn(createItensEntityList());
    service.cadastraPedido(createPedidoRequest());
    verify(clienteRepository, times(1)).findById(anyLong());
    verify(produtosRepository, times(1)).findById(anyLong());
  }

  @Test
  public void buscaPedidosTest() {
    when(pedidoItensRepository.findAll()).thenReturn(createItensEntityList());
    List<PedidoResponse> response = service.buscaPedidos();
    assertEquals(response.get(0).getProduto(), createItensEntityList().get(0).getProduto());
    verify(pedidoItensRepository, times(1)).findAll();
  }

  @Test
  public void buscaPedidoPeloIDTest() throws NotFoundException {
    when(pedidoItensRepository.findById(anyLong())).thenReturn(
        Optional.ofNullable(createItensEntityList().get(0)));
    PedidoResponse response = service.buscaPedidoPeloID(anyLong());
    assertEquals(response.getProduto(), createItensEntityList().get(0).getProduto());
    verify(pedidoItensRepository, times(1)).findById(anyLong());
  }
}
