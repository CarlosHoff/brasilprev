package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.request.ProdutoRequest;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table(name = "PRODUTOS")
@Entity
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTOS")
    @SequenceGenerator(sequenceName = "SQ_PRODUTOS", allocationSize = 1, name = "SQ_PRODUTOS")
    @Column(name = "ID_PRODUTOS")
    private Long idProdutos;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORIA")
    private CategoriaEntity categoriaEntity;

    @Column(name = "PRODUTO", nullable = false)
    private String produto;

    @Column(name = "PRECO", nullable = false)
    private Double preco;

    @Column(name = "QUANTIDADE", nullable = false)
    private Long quantidade;

    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @Lob
    @Column(name = "FOTO", nullable = false)
    private byte[] foto;

    public ProdutosEntity() {
    }

    public ProdutosEntity(ProdutoRequest request) {
        this.produto = request.getProduto();
        this.preco = request.getPreco();
        this.quantidade = request.getQuantidade();
        this.descricao = request.getDescricao();
        this.foto = request.getFoto();
    }
}
