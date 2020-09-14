package br.com.hoffmann.brasilprev.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.hoffmann.brasilprev.domain.request.PedidoRequest;
import br.com.hoffmann.brasilprev.domain.response.BrasilPrevResponse;
import br.com.hoffmann.brasilprev.domain.response.PedidoResponse;
import br.com.hoffmann.brasilprev.domain.response.ProdutoResponse;
import br.com.hoffmann.brasilprev.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javassist.NotFoundException;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "BrasilPrev - Cadastro de pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = "/v1/brasilprev")
public class PedidoController {

  @Autowired
  private PedidoService service;

  @ApiOperation(value = "BrasilPrev - API para Cadastro de Pedidos", nickname = "cadastraPedido")
  @PostMapping(value = "/cadastraPedido", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<BrasilPrevResponse> cadastraPedido(
      @RequestBody PedidoRequest request) throws NotFoundException {
    service.cadastraPedido(request);
    return new ResponseEntity<>(CREATED);
  }

  @ApiOperation(value = "EndPoint para exclusão de Pedidos")
  @DeleteMapping(value = "/deletaPedido/{id}")
  public void deletaPedido(
      @PathVariable(value = "id") @NotNull Long id) {
    service.deletaPedido(id);
  }

  @ApiOperation(value = "EndPoint para fazer a busca de Pedidos")
  @GetMapping(value = "/buscaPedidos")
  public ResponseEntity<List<PedidoResponse>> buscaPedidos() {
    List<PedidoResponse> response = service.buscaPedidos();
    return ResponseEntity.ok().body(response);
  }

  @ApiOperation(value = "EndPoint para fazer a busca de Pedidos pelo id")
  @GetMapping(value = "/buscaPedidoPeloID/{id}")
  public ResponseEntity<PedidoResponse> buscaPedidoPeloID(
      @RequestParam(value = "id") Long id) throws NotFoundException {
    PedidoResponse response = service.buscaPedidoPeloID(id);
    return ResponseEntity.ok().body(response);
  }
}
