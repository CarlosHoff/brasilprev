package br.com.hoffmann.brasilprev.entity;

import br.com.hoffmann.brasilprev.domain.request.CategoriaRequest;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "CATEGORIA")
@Entity
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA")
    @SequenceGenerator(sequenceName = "SQ_CATEGORIA", allocationSize = 1, name = "SQ_CATEGORIA")
    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;

    @Column(name = "CATEGORIA", nullable = false)
    private String categoria;

    public CategoriaEntity(CategoriaRequest request) {
        this.categoria = request.getCategoria();
    }
}
