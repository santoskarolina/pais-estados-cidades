package santos.karolina.consultaDeCidades.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import santos.karolina.consultaDeCidades.entities.Cidade;
import santos.karolina.consultaDeCidades.entities.DTO.CidadeDTO;
import santos.karolina.consultaDeCidades.services.CidadeService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/cidades")
public class CidadeResource {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> create(@Valid @RequestBody CidadeDTO cidadeDTO){
        Cidade cidade = cidadeService.fromDTO(cidadeDTO);
        cidade =  cidadeService.create(cidade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cidade.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
