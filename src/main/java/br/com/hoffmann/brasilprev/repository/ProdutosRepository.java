package br.com.hoffmann.brasilprev.repository;

import br.com.hoffmann.brasilprev.entity.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long> {
}
