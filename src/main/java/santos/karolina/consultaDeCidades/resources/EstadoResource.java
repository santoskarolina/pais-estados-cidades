package santos.karolina.consultaDeCidades.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import santos.karolina.consultaDeCidades.entities.Cidade;
import santos.karolina.consultaDeCidades.entities.DTO.EstadoDTO;
import santos.karolina.consultaDeCidades.entities.Estado;
import santos.karolina.consultaDeCidades.entities.Pais;
import santos.karolina.consultaDeCidades.services.CidadeService;
import santos.karolina.consultaDeCidades.services.EstadoService;
import santos.karolina.consultaDeCidades.services.PaisService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/estados")
public class EstadoResource {

    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeService cidadeService;

    @GetMapping(value = "/busca")
    public ResponseEntity<Estado> findByNome(@RequestParam String nome){
        Estado estado = estadoService.findByNome(nome);
        return ResponseEntity.ok().body(estado);
    }

    @GetMapping(value = "/{estadoId}/cidades")
    public ResponseEntity<List<Cidade>> findByEstado(@PathVariable Long estadoId){
        List<Cidade> cidades = cidadeService.findByEstado(estadoId);
        return ResponseEntity.ok().body(cidades);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Estado> findById(@PathVariable Long id){
        Estado estado = estadoService.findById(id);
        return ResponseEntity.ok().body(estado);
    }

    @PostMapping
    public ResponseEntity<Estado> create(@Valid @RequestBody EstadoDTO estadoDTO){
        Estado estado = estadoService.fromDTO(estadoDTO);
        estado = estadoService.create(estado);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estado.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
