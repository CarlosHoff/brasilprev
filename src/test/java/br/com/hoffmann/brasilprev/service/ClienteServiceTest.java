package br.com.hoffmann.brasilprev.service;

import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.clienteRequest;
import static br.com.hoffmann.brasilprev.mother.BrasilPrevMother.createClienteEntity;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.hoffmann.brasilprev.domain.response.ClienteResponse;
import br.com.hoffmann.brasilprev.repository.ClienteRepository;
import br.com.hoffmann.brasilprev.utils.CriptografiaUtils;
import java.util.Collections;
import java.util.List;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {

  @InjectMocks
  private ClienteService clienteService;

  @Mock
  private ClienteRepository clienteRepository;

  @Mock
  private CriptografiaUtils criptografiaUtils;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void cadastraClienteTest() {
    when(clienteRepository.save(any())).thenReturn(createClienteEntity());
    when(criptografiaUtils.encode(any())).thenReturn(anyString());
    clienteService.cadastraCliente(clienteRequest());
    verify(clienteRepository, times(1)).save(any());
    verify(criptografiaUtils, times(1)).encode(any());
  }

  @Test
  public void buscaClientesTest() {
    when(clienteRepository.findAll()).thenReturn(Collections.singletonList(createClienteEntity()));
    List<ClienteResponse> response = clienteService.buscaClientes();
    assertEquals(response.get(0).getEmail(), createClienteEntity().getEmail());
    verify(clienteRepository, times(1)).findAll();
  }

  @Test
  public void buscaClientePeloIDTest() throws NotFoundException {
    when(clienteRepository.findById(anyLong())).thenReturn(java.util.Optional.of(
        createClienteEntity()));
    ClienteResponse response = clienteService.buscaClientePeloID(anyLong());
    assertEquals(response.getEmail(), createClienteEntity().getEmail());
    verify(clienteRepository, times(1)).findById(anyLong());
  }
}
