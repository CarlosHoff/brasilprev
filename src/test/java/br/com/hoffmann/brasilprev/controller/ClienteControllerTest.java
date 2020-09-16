package br.com.hoffmann.brasilprev.controller;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.V1_BRASILPREV;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.clienteRequest;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import br.com.hoffmann.brasilprev.config.ConfigTest;
import br.com.hoffmann.brasilprev.domain.response.ClienteResponse;
import br.com.hoffmann.brasilprev.service.ClienteService;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public class ClienteControllerTest extends ConfigTest {

  @InjectMocks
  private ClienteController clienteController;

  @Mock
  private ClienteService clienteService;

  private ObjectMapper objectMapper = new ObjectMapper();

  private MockMvc mvc;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    this.mvc = MockMvcBuilders
        .standaloneSetup(clienteController)
        .build();
  }

  @BeforeTest
  public void beforeTest() throws Exception {

  }

  @AfterMethod
  public void reset_mocks() {
    Mockito.reset(clienteService);
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
    mvc.perform(delete(V1_BRASILPREV + "/deletacliente/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void buscaClientesTest() throws Exception {
    when(clienteService.buscaClientes()).thenReturn(
        Collections.singletonList(new ClienteResponse()));
    mvc.perform(get(V1_BRASILPREV + "/buscaclientes")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(content()
            .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
  }
}