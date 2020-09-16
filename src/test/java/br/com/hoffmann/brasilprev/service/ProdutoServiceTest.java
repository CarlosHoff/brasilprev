package br.com.hoffmann.brasilprev.service;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createCategoriaEntity;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createCategoriaRequest;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createProdutosEntity;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createProdutosRequest;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;

import br.com.hoffmann.brasilprev.domain.response.ProdutoResponse;
import br.com.hoffmann.brasilprev.repository.CategoriaRepository;
import br.com.hoffmann.brasilprev.repository.ProdutosRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProdutoServiceTest {

  @InjectMocks
  private ProdutoService service;

  @Mock
  private CategoriaRepository categoriaRepository;

  @Mock
  private ProdutosRepository produtosRepository;

  @Before
  public void createMocks() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void cadastraProdutoTest() throws NotFoundException {
    when(categoriaRepository.findById(anyLong())).thenReturn(Optional.of(createCategoriaEntity()));
    when(produtosRepository.save(any())).thenReturn(createProdutosEntity());
    service.cadastraProduto(createProdutosRequest(), 1L);
    verify(categoriaRepository, times(1)).findById(anyLong());
    verify(produtosRepository, times(1)).save(any());
  }

  @Test
  public void cadastraCategoriaTest() {
    when(categoriaRepository.save(any())).thenReturn(createCategoriaEntity());
    service.cadastraCategoria(createCategoriaRequest());
    verify(categoriaRepository, times(1)).save(any());
  }

  @Test
  public void buscaProdutosTest() {
    when(produtosRepository.findAll())
        .thenReturn(Collections.singletonList(createProdutosEntity()));
    List<ProdutoResponse> response = service.buscaProdutos();
    assertEquals(response.get(0).getDescricao(), createProdutosEntity().getDescricao());
    verify(produtosRepository, times(1)).findAll();
  }

  @Test
  public void buscaProdutoPeloIDTest() throws NotFoundException {
    when(produtosRepository.findById(anyLong())).thenReturn(Optional.of(createProdutosEntity()));
    ProdutoResponse response = service.buscaProdutoPeloID(anyLong());
    assertEquals(response.getProduto(), createProdutosEntity().getProduto());
  }
}
