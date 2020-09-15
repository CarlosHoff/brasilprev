package br.com.hoffmann.brasilprev.service;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.clienteRequest;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createClienteEntity;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.testng.AssertJUnit.assertEquals;

import br.com.hoffmann.brasilprev.domain.response.ClienteResponse;
import br.com.hoffmann.brasilprev.repository.ClienteRepository;
import java.util.Collections;
import java.util.List;
import javassist.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;

@AutoConfigureMockMvc
public class ClienteServiceTest extends AbstractTestNGSpringContextTests {

  @InjectMocks
  private ClienteService service;

  @Mock
  private ClienteRepository clienteRepository;

  @BeforeMethod
  public void beforeTest() {
    initMocks(this);
  }

  @Test
  public void cadastraClienteTest() {
    doNothing().when(clienteRepository.save(createClienteEntity()));
    service.cadastraCliente(clienteRequest());
    verify(clienteRepository, times(1)).save(createClienteEntity());
  }

  @Test
  public void buscaClientesTest() {
    when(clienteRepository.findAll()).thenReturn(Collections.singletonList(createClienteEntity()));
    List<ClienteResponse> response = service.buscaClientes();
    assertEquals(response.get(0).getEmail(), createClienteEntity().getEmail());
    verify(clienteRepository, times(1)).findAll();
  }

  @Test
  public void buscaClientePeloIDTest() throws NotFoundException {
    when(clienteRepository.findById(anyLong())).thenReturn(java.util.Optional.of(
        createClienteEntity()));
    ClienteResponse response = service.buscaClientePeloID(anyLong());
    assertEquals(response.getEmail(), createClienteEntity().getEmail());
    verify(clienteRepository, times(1)).findById(anyLong());
  }
}
