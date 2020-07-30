package br.com.hoffmann.brasilprev.service;

import br.com.hoffmann.brasilprev.domain.enums.BrasilPrevEnum;
import br.com.hoffmann.brasilprev.domain.request.CategoriaRequest;
import br.com.hoffmann.brasilprev.domain.request.ClienteRequest;
import br.com.hoffmann.brasilprev.domain.request.PedidoItens;
import br.com.hoffmann.brasilprev.domain.request.PedidoRequest;
import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    private ClienteEntity getCliente(PedidoRequest request) throws NotFoundException {
        Optional<ClienteEntity> cliente = clienteRepository.findById(request.getCliente());
        if (!cliente.isPresent()) {
            throw new NotFoundException(String.format("Cliente não cadastrado", cliente.get().getNome()));
        }
        return cliente.get();
    }

    public void cadastraPedido(PedidoRequest request) throws NotFoundException {

        ClienteEntity cliente = getCliente(request);

        PedidosEntity pedidos = new PedidosEntity();
        pedidos.setClienteEntity(cliente);
        pedidos.setData(LocalDate.now());
        pedidos.setStatus(BrasilPrevEnum.ANALISE);
        pedidos.setSessao(JOGOS);
        PedidosEntity pedidoSalvo = pedidosRepository.save(pedidos);

        List<PedidoItensEntity> listItens = new ArrayList<>();
        for (PedidoItens pi : request.getItensDoPedido()) {
            Optional<ProdutosEntity> produtos = produtosRepository.findById(pi.getProduto());
            if (!produtos.isPresent()) {
                throw new NotFoundException("Produto não existe na base");
            }
            ProdutosEntity produto = produtos.get();
            PedidoItensEntity pedido = new PedidoItensEntity();
            pedido.setPedidosEntity(pedidoSalvo);
            pedido.setValor(produto.getPreco());
            pedido.setSubtotal(produto.getPreco() * pi.getQuantidade());
            pedido.setQuantidade(produto.getQuantidade());
            pedido.setProduto(produto.getProduto());
            pedido.setPedidosEntity(pedidoSalvo);
            listItens.add(pedido);
        }
        pedidoItensRepository.saveAll(listItens);
    }

    public void cadastraCliente(ClienteRequest request) {
        clienteRepository.save(new ClienteEntity(request));
    }

    public void cadastraCategoria(CategoriaRequest request) {
        categoriaRepository.save(new CategoriaEntity(request));
    }

    public void cadastraProduto(ProdutoRequest request, Long idCategoria) throws NotFoundException {
        ProdutosEntity produto = new ProdutosEntity(request);
        Optional<CategoriaEntity> getCategoria = categoriaRepository.findById(idCategoria);
        if (!getCategoria.isPresent()) {
            throw new NotFoundException("Categoria não encontrada");
        }
        produto.setCategoriaEntity(getCategoria.get());
        produtosRepository.save(produto);
    }
}
