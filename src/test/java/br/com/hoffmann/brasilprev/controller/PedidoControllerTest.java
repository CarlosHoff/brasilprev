package br.com.hoffmann.brasilprev.controller;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.V1_BRASILPREV;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.clienteRequest;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createPedidoRequest;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.hoffmann.brasilprev.config.ControllerConfigTest;
import br.com.hoffmann.brasilprev.domain.response.PedidoResponse;
import br.com.hoffmann.brasilprev.service.PedidoService;
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
public class PedidoControllerTest extends ControllerConfigTest {

  @Autowired
  private WebApplicationContext applicationContext;

  @InjectMocks
  private ClienteController clienteController;

  @Mock
  private PedidoService pedidoService;

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
  public void cadastraPedidoTest() throws Exception {
    doNothing().when(pedidoService).cadastraPedido(createPedidoRequest());
    mvc.perform(post(V1_BRASILPREV + "/cadastraPedido")
        .contentType(MediaType.APPLICATION_JSON)
        .content(this.objectMapper.writeValueAsString(clienteRequest())))
        .andExpect(status().isCreated());
  }

  @Test
  public void deletaPedidoTest() throws Exception {
    doNothing().when(pedidoService).deletaPedido(anyLong());
    mvc.perform(post(V1_BRASILPREV + "/deletaPedido/{id}")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void buscaPedidosTest() throws Exception {
    when(pedidoService.buscaPedidos()).thenReturn(
        Collections.singletonList(new PedidoResponse()));
    mvc.perform(post(V1_BRASILPREV + "/buscaPedidos")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }

  @Test
  public void buscaPedidosPeloIDTest() throws Exception {
    when(pedidoService.buscaPedidoPeloID(anyLong())).thenReturn(new PedidoResponse());
    mvc.perform(post(V1_BRASILPREV + "/buscaPedidoPeloID/{id}")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }
}
