package br.com.hoffmann.brasilprev.repository;

import br.com.hoffmann.brasilprev.entity.ClienteEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

  Optional<ClienteEntity> findByEmail(String email);
}
