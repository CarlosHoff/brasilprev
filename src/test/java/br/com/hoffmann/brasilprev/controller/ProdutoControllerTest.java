package br.com.hoffmann.brasilprev.controller;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.V1_BRASILPREV;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.clienteRequest;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createCategoriaRequest;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createProdutosRequest;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.hoffmann.brasilprev.config.ControllerConfigTest;
import br.com.hoffmann.brasilprev.domain.response.ProdutoResponse;
import br.com.hoffmann.brasilprev.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Collections;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProdutoControllerTest extends ControllerConfigTest {

  @Autowired
  private WebApplicationContext applicationContext;

  @InjectMocks
  private ClienteController clienteController;

  @Mock
  private ProdutoService produtoService;

  @Autowired
  private ObjectMapper objectMapper;

  private MockMvc mvc;

  @Before
  public void setup() {
    this.mvc = MockMvcBuilders
        .webAppContextSetup(applicationContext)
        .build();
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
  public void cadastraProdutoTest() throws Exception {
    doNothing().when(produtoService).cadastraProduto(createProdutosRequest(), anyLong());
    mvc.perform(post(V1_BRASILPREV + "/cadastraproduto")
        .contentType(MediaType.APPLICATION_JSON)
        .content(this.objectMapper.writeValueAsString(clienteRequest())))
        .andExpect(status().isCreated());
  }

  @Test
  public void deletaProdutoTest() throws Exception {
    doNothing().when(produtoService).deletaProduto(anyLong());
    mvc.perform(post(V1_BRASILPREV + "/deletaproduto/{id}")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void buscaProdutosTest() throws Exception {
    when(produtoService.buscaProdutos()).thenReturn(
        Collections.singletonList(new ProdutoResponse()));
    mvc.perform(post(V1_BRASILPREV + "/buscaprodutos")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }

  @Test
  public void buscaProdutosPeloIDTest() throws Exception {
    when(produtoService.buscaProdutoPeloID(anyLong())).thenReturn(new ProdutoResponse());
    mvc.perform(post(V1_BRASILPREV + "/buscaprodutopeloid/{id}")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }
}
