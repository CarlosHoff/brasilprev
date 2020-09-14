package br.com.hoffmann.brasilprev.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import br.com.hoffmann.brasilprev.domain.request.CategoriaRequest;
import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
import br.com.hoffmann.brasilprev.domain.response.BrasilPrevResponse;
import br.com.hoffmann.brasilprev.domain.response.ProdutoResponse;
import br.com.hoffmann.brasilprev.service.ProdutoService;
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

@Api(value = "BrasilPrev - Cadastro de produtos", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping(path = "/v1/brasilprev")
public class ProdutoController {

  @Autowired
  private ProdutoService service;

  @ApiOperation(value = "BrasilPrev - API para Cadastro de Categoria", nickname = "cadastraCategoria")
  @PostMapping(value = "/cadastraCategoria", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<BrasilPrevResponse> cadastraCategoria(
      @RequestBody CategoriaRequest request) {
    service.cadastraCategoria(request);
    return new ResponseEntity<>(CREATED);
  }

  @ApiOperation(value = "BrasilPrev - API para Cadastro de Categoria", nickname = "cadastraProduto")
  @PostMapping(value = "/cadastraProduto", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<BrasilPrevResponse> cadastraProduto(@RequestBody ProdutoRequest request,
      @RequestParam Long idCategoria) throws NotFoundException {
    service.cadastraProduto(request, idCategoria);
    return new ResponseEntity<>(CREATED);
  }

  @ApiOperation(value = "EndPoint para exclusão de Produtos")
  @DeleteMapping(value = "/deletaProduto/{id}")
  public void deletaProduto(
      @PathVariable(value = "id") @NotNull Long id) {
    service.deletaProduto(id);
  }

  @ApiOperation(value = "EndPoint para fazer a busca de Produtos")
  @GetMapping(value = "/buscaProdutos")
  public ResponseEntity<List<ProdutoResponse>> buscaProdutos() {
    List<ProdutoResponse> response = service.buscaProdutos();
    return ResponseEntity.ok().body(response);
  }

  @ApiOperation(value = "EndPoint para fazer a busca de Produtos pelo id")
  @GetMapping(value = "/buscaProdutoPeloID/{id}")
  public ResponseEntity<ProdutoResponse> buscaProdutoPeloID(
      @RequestParam(value = "id") Long id) throws NotFoundException {
    ProdutoResponse response = service.buscaProdutoPeloID(id);
    return ResponseEntity.ok().body(response);
  }

  @ApiOperation(value = "EndPoint para alteração de informações dos Produtos")
  @PutMapping(value = "/updateProduto/{id}")
  public ResponseEntity<ProdutoResponse> updateProduto(
      @PathVariable(value = "id") @NotNull Long id,
      @RequestBody @Valid ProdutoRequest request) throws NotFoundException {
    service.updateProduto(request, id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
