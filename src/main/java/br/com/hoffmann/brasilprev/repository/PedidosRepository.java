package br.com.hoffmann.brasilprev.repository;

import br.com.hoffmann.brasilprev.entity.PedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<PedidosEntity, Long> {
}
