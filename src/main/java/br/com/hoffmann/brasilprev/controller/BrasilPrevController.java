package br.com.hoffmann.brasilprev.controller;

import br.com.hoffmann.brasilprev.domain.request.CategoriaRequest;
import br.com.hoffmann.brasilprev.domain.request.ClienteRequest;
import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
import br.com.hoffmann.brasilprev.domain.response.BrasilPrevResponse;
import br.com.hoffmann.brasilprev.service.BrasilPrevService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "BrasilPrev - Cadastro de produto", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(path = "/v1/brasilprev")
public class BrasilPrevController {

    @Autowired
    private BrasilPrevService service;

    @ApiOperation(value = "BrasilPrev - API para Cadastro de Produtos", nickname = "cadastraProduto")
    @RequestMapping(value = "/cadastraProduto", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<BrasilPrevResponse> cadastraProduto(
            @RequestBody ProdutoRequest request) throws NotFoundException {
        service.cadastraProduto(request);
        return new ResponseEntity<>(CREATED);
    }

    @ApiOperation(value = "BrasilPrev - API para Cadastro de Clientes", nickname = "cadastraCliente")
    @RequestMapping(value = "/cadastraCliente", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<BrasilPrevResponse> cadastraCliente(@RequestBody ClienteRequest request) {
        service.cadastraCliente(request);
        return new ResponseEntity<>(CREATED);
    }

    @ApiOperation(value = "BrasilPrev - API para Cadastro de Categoria", nickname = "cadastraCategoria")
    @RequestMapping(value = "/cadastraCategoria", produces = APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<BrasilPrevResponse> cadastraCategoria(@RequestBody CategoriaRequest request) {
        service.cadastraCategoria(request);
        return new ResponseEntity<>(CREATED);
    }
}

