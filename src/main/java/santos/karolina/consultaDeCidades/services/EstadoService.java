package santos.karolina.consultaDeCidades.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santos.karolina.consultaDeCidades.entities.DTO.EstadoDTO;
import santos.karolina.consultaDeCidades.entities.Estado;
import santos.karolina.consultaDeCidades.entities.Pais;
import santos.karolina.consultaDeCidades.repositories.EstadoRepository;
import santos.karolina.consultaDeCidades.services.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findByPais(Long paisId){
        return estadoRepository.findEstadoByPais(paisId);
    }

    public Estado findByNome(String nome){
        Optional<Estado> estado = estadoRepository.findByNomeIgnoreCase(nome);
        return estado.orElseThrow(() -> new NotFoundException("Estado não encontrado"));
    }

    public Estado findById(Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        return estado.orElseThrow(() -> new NotFoundException("Estado não encontrado"));
    }

    public Estado create(Estado estado){
        return estadoRepository.save(estado);
    }

    public Estado fromDTO(EstadoDTO estadoDTO){
        Pais pais = new Pais(estadoDTO.getPais(), null, null,null,null);
        Estado estado = new Estado(null, estadoDTO.getNome(), estadoDTO.getUf(), estadoDTO.getIbge(), pais);

        pais.getEstados().add(estado);
        return estado;
    }
}
