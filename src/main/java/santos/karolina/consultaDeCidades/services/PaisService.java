package santos.karolina.consultaDeCidades.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santos.karolina.consultaDeCidades.entities.DTO.PaisDTO;
import santos.karolina.consultaDeCidades.entities.Pais;
import santos.karolina.consultaDeCidades.repositories.PaisRepository;
import santos.karolina.consultaDeCidades.services.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public List<Pais> findAll(){
        return paisRepository.findAll();
    }

    public Pais findById(Long id){
        Optional<Pais> pais = paisRepository.findById(id);
        return pais.orElseThrow(()-> new RuntimeException("pais não encontrado"));
    }

    public Pais findByNome(String nome){
        Optional<Pais> pais = paisRepository.findByNomeIgnoreCase(nome);
        return pais.orElseThrow(() -> new NotFoundException("Pais não encontrado"));
    }

    public Pais create(Pais pais){
        return paisRepository.save(pais);
    }

    public Pais fromDTO(PaisDTO paisDTO){
        Pais pais = new Pais(null, paisDTO.getNome(),paisDTO.getNomePt(), paisDTO.getSigla(),paisDTO.getBacen());
        return pais;
    }

}
