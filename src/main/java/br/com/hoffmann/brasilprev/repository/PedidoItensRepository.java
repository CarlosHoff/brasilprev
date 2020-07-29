package br.com.hoffmann.brasilprev.repository;

import br.com.hoffmann.brasilprev.entity.PedidoItensEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItensRepository extends JpaRepository<PedidoItensEntity, Long> {
}
