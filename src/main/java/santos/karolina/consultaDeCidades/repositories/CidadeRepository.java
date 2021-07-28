package santos.karolina.consultaDeCidades.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import santos.karolina.consultaDeCidades.entities.Cidade;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Transactional(readOnly = true)
    @Query("SELECT obj FROM Cidade obj WHERE obj.estado.id = :estadoId ORDER BY obj.nome")
    List<Cidade> findCidadeByEstado(Long estadoId);
}