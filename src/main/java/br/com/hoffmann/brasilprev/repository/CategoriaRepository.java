package br.com.hoffmann.brasilprev.repository;

import br.com.hoffmann.brasilprev.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    CategoriaEntity findByCategoria(String categoria);
}
