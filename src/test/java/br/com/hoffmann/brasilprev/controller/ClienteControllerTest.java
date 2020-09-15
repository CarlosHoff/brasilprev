package br.com.hoffmann.brasilprev.controller;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.V1_BRASILPREV;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.clienteRequest;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.hoffmann.brasilprev.config.ControllerConfigTest;
import br.com.hoffmann.brasilprev.domain.response.ClienteResponse;
import br.com.hoffmann.brasilprev.service.ClienteService;
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
public class ClienteControllerTest extends ControllerConfigTest {

  @Autowired
  private WebApplicationContext applicationContext;

  @InjectMocks
  private ClienteController clienteController;

  @Mock
  private ClienteService clienteService;

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
  public void cadastraClienteTest() throws Exception {
    doNothing().when(clienteService).cadastraCliente(clienteRequest());
    mvc.perform(post(V1_BRASILPREV + "/cadastracliente")
        .contentType(MediaType.APPLICATION_JSON)
        .content(this.objectMapper.writeValueAsString(clienteRequest())))
        .andExpect(status().isCreated());
  }

  @Test
  public void deletaClienteTest() throws Exception {
    doNothing().when(clienteService).deletaCliente(anyLong());
    mvc.perform(post(V1_BRASILPREV + "/deletacliente")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void buscaClientesTest() throws Exception {
    when(clienteService.buscaClientes()).thenReturn(
        Collections.singletonList(new ClienteResponse()));
    mvc.perform(post(V1_BRASILPREV + "/buscaclientes")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }

  @Test
  public void buscaClientesPeloIDTest() throws Exception {
    when(clienteService.buscaClientes()).thenReturn(
        Collections.singletonList(new ClienteResponse()));
    mvc.perform(post(V1_BRASILPREV + "/buscaclientepeloid/{id}")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }
}