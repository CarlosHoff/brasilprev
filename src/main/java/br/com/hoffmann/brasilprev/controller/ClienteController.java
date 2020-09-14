package br.com.hoffmann.brasilprev.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.hoffmann.brasilprev.domain.request.ClienteRequest;
import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
import br.com.hoffmann.brasilprev.domain.response.BrasilPrevResponse;
import br.com.hoffmann.brasilprev.domain.response.ClienteResponse;
import br.com.hoffmann.brasilprev.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javassist.NotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "BrasilPrev - Cadastro de clientes", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = "/v1/brasilprev")
public class ClienteController {

  @Autowired
  private ClienteService service;

  @ApiOperation(value = "BrasilPrev - API para Cadastro de Clientes", nickname = "cadastraCliente")
  @PostMapping(value = "/cadastraCliente", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<BrasilPrevResponse> cadastraCliente(@RequestBody ClienteRequest request) {
    service.cadastraCliente(request);
    return new ResponseEntity<>(CREATED);
  }

  @ApiOperation(value = "EndPoint para exclusão de Clientes")
  @DeleteMapping(value = "/deletaCliente/{id}")
  public void deletaCliente(
      @PathVariable(value = "id") @NotNull Long id) {
    service.deletaCliente(id);
  }

  @ApiOperation(value = "EndPoint para fazer a busca de Clientes")
  @GetMapping(value = "/buscaClientes")
  public ResponseEntity<List<ClienteResponse>> buscaClientes() {
    List<ClienteResponse> response = service.buscaClientes();
    return ResponseEntity.ok().body(response);
  }

  @ApiOperation(value = "EndPoint para fazer a busca de Clientes id")
  @GetMapping(value = "/buscaClientePeloID/{id}")
  public ResponseEntity<ClienteResponse> buscaClientePeloID(
      @RequestParam(value = "id") Long id) throws NotFoundException {
    ClienteResponse response = service.buscaClientePeloID(id);
    return ResponseEntity.ok().body(response);
  }

}
