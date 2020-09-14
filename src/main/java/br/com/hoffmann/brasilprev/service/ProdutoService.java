package br.com.hoffmann.brasilprev.service;

import static java.lang.String.format;

import br.com.hoffmann.brasilprev.domain.request.CategoriaRequest;
import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
import br.com.hoffmann.brasilprev.domain.response.ProdutoResponse;
import br.com.hoffmann.brasilprev.entity.CategoriaEntity;
import br.com.hoffmann.brasilprev.entity.ProdutosEntity;
import br.com.hoffmann.brasilprev.repository.CategoriaRepository;
import br.com.hoffmann.brasilprev.repository.ProdutosRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "transactionManager")
public class ProdutoService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Autowired
  private ProdutosRepository produtosRepository;

  public void cadastraProduto(ProdutoRequest request, Long idCategoria) throws NotFoundException {
    ProdutosEntity produto = new ProdutosEntity(request);
    Optional<CategoriaEntity> getCategoria = categoriaRepository.findById(idCategoria);
    if (!getCategoria.isPresent()) {
      throw new NotFoundException(
          String.format("Categoria [%s] não encontrada", getCategoria.get().getCategoria()));
    }
    produto.setCategoriaEntity(getCategoria.get());
    produtosRepository.save(produto);
  }

  public void cadastraCategoria(CategoriaRequest request) {
    categoriaRepository.save(new CategoriaEntity(request));
  }

  public void deletaProduto(Long id) {
    produtosRepository.deleteById(id);
  }

  public List<ProdutoResponse> buscaProdutos() {
    List<ProdutosEntity> produtos = produtosRepository.findAll();
    return produtos.stream().map(ProdutoResponse::new).collect(Collectors.toList());
  }

  public ProdutoResponse buscaProdutoPeloID(Long id) throws NotFoundException {
    Optional<ProdutosEntity> produto = produtosRepository.findById(id);
    if (!produto.isPresent()) {
      throw new NotFoundException(format("Produto [%s] não encontrado", id));
    }
    return new ProdutoResponse(produto.get());
  }

  public void updateProduto(ProdutoRequest request, Long id) throws NotFoundException {
    Optional<ProdutosEntity> produto = produtosRepository.findById(id);
    if (!produto.isPresent()) {
      throw new NotFoundException(format("[%s] não encontrado", id));
    }
    atualizaProduto(produto.get(), request);
  }

  private void atualizaProduto(ProdutosEntity produto, ProdutoRequest request) {
    produto.setFoto(request.getFoto());
    produto.setPreco(request.getPreco());
    produto.setQuantidade(request.getQuantidade());
    produto.setProduto(request.getProduto());
    produto.setDescricao(request.getDescricao());
    produtosRepository.save(produto);
  }
}
