package santos.karolina.consultaDeCidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import santos.karolina.consultaDeCidades.entities.Estado;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Estado obj WHERE obj.pais.id = :paisId ORDER BY obj.nome")
    List<Estado> findEstadoByPais(Long paisId);

    @Transactional(readOnly = true)
    Optional<Estado> findByNomeIgnoreCase(String nome);
}
