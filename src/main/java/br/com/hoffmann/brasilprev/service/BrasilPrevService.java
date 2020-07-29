package br.com.hoffmann.brasilprev.service;

import br.com.hoffmann.brasilprev.domain.enums.BrasilPrevEnum;
import br.com.hoffmann.brasilprev.domain.request.CategoriaRequest;
import br.com.hoffmann.brasilprev.domain.request.ClienteRequest;
import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
import br.com.hoffmann.brasilprev.domain.request.Produtos;
import br.com.hoffmann.brasilprev.entity.CategoriaEntity;
import br.com.hoffmann.brasilprev.entity.ClienteEntity;
import br.com.hoffmann.brasilprev.entity.PedidoItensEntity;
import br.com.hoffmann.brasilprev.entity.PedidosEntity;
import br.com.hoffmann.brasilprev.entity.ProdutosEntity;
import br.com.hoffmann.brasilprev.repository.CategoriaRepository;
import br.com.hoffmann.brasilprev.repository.ClienteRepository;
import br.com.hoffmann.brasilprev.repository.PedidoItensRepository;
import br.com.hoffmann.brasilprev.repository.PedidosRepository;
import br.com.hoffmann.brasilprev.repository.ProdutosRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(value = "transactionManager")
public class BrasilPrevService {

    private static final String JOGOS = "jogos";

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoItensRepository pedidoItensRepository;

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    private ClienteEntity getCliente(ProdutoRequest request) throws NotFoundException {
        Optional<ClienteEntity> cliente = clienteRepository.findById(request.getCliente());
        if (!cliente.isPresent()) {
            throw new NotFoundException(String.format("Cliente não cadastrado", cliente.get().getNome()));
        }
        return cliente.get();
    }

    public void cadastraProduto(ProdutoRequest request) throws NotFoundException {

        ClienteEntity clienteEntity = getCliente(request);

        PedidosEntity pedidosEntity = new PedidosEntity();
        pedidosEntity.setClienteEntity(clienteEntity);
        pedidosEntity.setData(LocalDate.now());
        pedidosEntity.setStatus(BrasilPrevEnum.ANALISE);
        pedidosEntity.setSessao(JOGOS);
        PedidosEntity pedidoSalvo = pedidosRepository.save(pedidosEntity);

        PedidoItensEntity pedidoItensEntity = new PedidoItensEntity();
        pedidoItensEntity.setPedidosEntity(pedidoSalvo);
        pedidoItensEntity.setProduto(request.getPedidoItens().getProduto());
        pedidoItensEntity.setQuantidade(request.getPedidoItens().getQuantidade());
        // TODO PEGA O PRECO DA TABELA DE PRODUTOS
        ProdutosEntity produtosEntity = produtosRepository.findByProduto(request.getPedidoItens().getProduto());
        pedidoItensEntity.setValor(produtosEntity.getPreco());
        // TODO CALCULA O TOTAL DA NOTA COM BASE NA REQUEST
        pedidoItensEntity.setSubtotal(calculaSubTotal(request));
        pedidoItensRepository.save(pedidoItensEntity);

        for (Produtos p : request.getPedidoItens().getProdutosList()) {
            CategoriaEntity getCategoria = categoriaRepository.findByCategoria(p.getCategoria().getCategoria());

            List<ProdutosEntity> produtosEntityList;
            produtosEntityList = request.getPedidoItens().getProdutosList().stream()
                    .map(ProdutosEntity::new).collect(Collectors.toList()).stream()
                    .peek(produto -> produto.setCategoriaEntity(getCategoria)).collect(Collectors.toList());
            List<ProdutosEntity> produtoSalvo = produtosRepository.saveAll(produtosEntityList);
            pedidoItensEntity.setProdutos(produtoSalvo);
        }
    }

    private Double calculaSubTotal(ProdutoRequest request) {
        Long quantidade = request.getPedidoItens().getProdutosList().stream().map(Produtos::getQuantidade).mapToLong(Long::longValue).sum();
        Double totalProduto = request.getPedidoItens().getProdutosList().stream().map(Produtos::getPreco).mapToDouble(Double::doubleValue).sum();
        return totalProduto * quantidade;
    }

    public void cadastraCliente(ClienteRequest request) {
        clienteRepository.save(new ClienteEntity(request));
    }

    public void cadastraCategoria(CategoriaRequest request) { categoriaRepository.save(new CategoriaEntity(request));
    }
}
