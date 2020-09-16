package br.com.hoffmann.brasilprev.controller;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.V1_BRASILPREV;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.clienteRequest;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createCategoriaRequest;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.hoffmann.brasilprev.config.ConfigTest;
import br.com.hoffmann.brasilprev.domain.response.ProdutoResponse;
import br.com.hoffmann.brasilprev.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class ProdutoControllerTest extends ConfigTest {

  @InjectMocks
  private ProdutoController produtoController;

  @Mock
  private ProdutoService produtoService;

  private ObjectMapper objectMapper = new ObjectMapper();

  private MockMvc mvc;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    this.mvc = MockMvcBuilders
        .standaloneSetup(produtoController)
        .build();
  }

  @BeforeTest
  public void beforeTest() throws Exception {

  }

  @AfterMethod
  public void reset_mocks() {
    Mockito.reset(produtoService);
  }

  @Test
  public void cadastraCategoriaTest() throws Exception {
    doNothing().when(produtoService).cadastraCategoria(createCategoriaRequest());
    mvc.perform(post(V1_BRASILPREV + "/cadastracategoria")
        .contentType(MediaType.APPLICATION_JSON)
        .content(this.objectMapper.writeValueAsString(clienteRequest())))
        .andExpect(status().isCreated());
  }

  @Test
  public void deletaProdutoTest() throws Exception {
    doNothing().when(produtoService).deletaProduto(anyLong());
    mvc.perform(delete(V1_BRASILPREV + "/deletaproduto/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void buscaProdutosTest() throws Exception {
    when(produtoService.buscaProdutos()).thenReturn(
        Collections.singletonList(new ProdutoResponse()));
    mvc.perform(get(V1_BRASILPREV + "/buscaprodutos")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }

}
