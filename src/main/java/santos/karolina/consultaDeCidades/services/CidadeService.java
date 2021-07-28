package santos.karolina.consultaDeCidades.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santos.karolina.consultaDeCidades.entities.Cidade;
import santos.karolina.consultaDeCidades.entities.DTO.CidadeDTO;
import santos.karolina.consultaDeCidades.entities.Estado;
import santos.karolina.consultaDeCidades.repositories.CidadeRepository;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> findByEstado(Long estadoId){
        return cidadeRepository.findCidadeByEstado(estadoId);
    }

    public Cidade create(Cidade cidade){
        return cidadeRepository.save(cidade);
    }

    public Cidade fromDTO(CidadeDTO cidadeDTO){
        Estado estado = new Estado(cidadeDTO.getEstado(), null, null, null, null);
        Cidade cidade = new Cidade(null,cidadeDTO.getNome().toUpperCase(), cidadeDTO.getIbge(), estado);

        estado.getCidades().add(cidade);
        return cidade;
    }
}
