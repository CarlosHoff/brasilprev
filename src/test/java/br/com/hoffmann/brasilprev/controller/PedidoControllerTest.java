package br.com.hoffmann.brasilprev.controller;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.V1_BRASILPREV;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.clienteRequest;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createPedidoRequest;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.hoffmann.brasilprev.config.ConfigTest;
import br.com.hoffmann.brasilprev.domain.response.PedidoResponse;
import br.com.hoffmann.brasilprev.service.PedidoService;
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

public class PedidoControllerTest extends ConfigTest {

  @InjectMocks
  private PedidoController pedidoController;

  @Mock
  private PedidoService pedidoService;

  private ObjectMapper objectMapper = new ObjectMapper();

  private MockMvc mvc;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    this.mvc = MockMvcBuilders
        .standaloneSetup(pedidoController)
        .build();
  }

  @BeforeTest
  public void beforeTest() throws Exception {

  }

  @AfterMethod
  public void reset_mocks() {
    Mockito.reset(pedidoService);
  }

  @Test
  public void cadastraPedidoTest() throws Exception {
    doNothing().when(pedidoService).cadastraPedido(createPedidoRequest());
    mvc.perform(post(V1_BRASILPREV + "/cadastrapedido")
        .contentType(MediaType.APPLICATION_JSON)
        .content(this.objectMapper.writeValueAsString(clienteRequest())))
        .andExpect(status().isCreated());
  }

  @Test
  public void deletaPedidoTest() throws Exception {
    doNothing().when(pedidoService).deletaPedido(anyLong());
    mvc.perform(delete(V1_BRASILPREV + "/deletapedido/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void buscaPedidosTest() throws Exception {
    when(pedidoService.buscaPedidos()).thenReturn(
        Collections.singletonList(new PedidoResponse()));
    mvc.perform(get(V1_BRASILPREV + "/buscapedidos")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }
}
