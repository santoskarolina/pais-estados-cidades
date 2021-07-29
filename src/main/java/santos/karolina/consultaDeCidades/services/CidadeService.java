package santos.karolina.consultaDeCidades.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import santos.karolina.consultaDeCidades.entities.Cidade;
import santos.karolina.consultaDeCidades.entities.DTO.CidadeDTO;
import santos.karolina.consultaDeCidades.entities.Estado;
import santos.karolina.consultaDeCidades.repositories.CidadeRepository;
import santos.karolina.consultaDeCidades.services.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

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

    public Cidade findByNome(String nome){
        Optional<Cidade> cidade = cidadeRepository.findByNomeIgnoreCase(nome);
        return cidade.orElseThrow(() -> new NotFoundException("Cidade não encontrada"));
    }

    public Cidade fromDTO(CidadeDTO cidadeDTO){
        Estado estado = new Estado(cidadeDTO.getEstado(), null, null, null, null);
        Cidade cidade = new Cidade(null,cidadeDTO.getNome().toUpperCase(), cidadeDTO.getIbge(), estado);

        estado.getCidades().add(cidade);
        return cidade;
    }
}
