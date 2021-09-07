package santos.karolina.consultaDeCidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import santos.karolina.consultaDeCidades.entities.Pais;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    @Transactional(readOnly = true)
    Optional<Pais> findByNomePtIgnoreCase(@Param("nomePt") String nomePt);
}
