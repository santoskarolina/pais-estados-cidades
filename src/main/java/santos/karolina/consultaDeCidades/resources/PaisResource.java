package santos.karolina.consultaDeCidades.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import santos.karolina.consultaDeCidades.entities.Estado;
import santos.karolina.consultaDeCidades.entities.Pais;
import santos.karolina.consultaDeCidades.entities.DTO.PaisDTO;
import santos.karolina.consultaDeCidades.services.EstadoService;
import santos.karolina.consultaDeCidades.services.PaisService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/paises")
public class PaisResource {

    @Autowired
    private PaisService service;

    @Autowired
    private EstadoService estadoService;


    @GetMapping
    public ResponseEntity<List<PaisDTO>> findALl(){
        List<Pais> pais = service.findAll();
        List<PaisDTO> dtoList = pais.stream().map(x -> new PaisDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pais> findById(@PathVariable Long id){
        Pais pais = service.findById(id);
        return ResponseEntity.ok().body(pais);
    }

    @GetMapping(value = "/{paisId}/estados")
    public ResponseEntity<List<Estado>> getAllEstados(@PathVariable Long paisId){
        List<Estado> estados = estadoService.findByPais(paisId);
        return ResponseEntity.ok().body(estados);

    }

    @GetMapping(value = "/busca")
    public ResponseEntity<Pais> findbyNome(@RequestParam String nomePt){
        Pais pais = service.findByNome(nomePt);
        return ResponseEntity.ok().body(pais);
    }

    @PostMapping
    public ResponseEntity<Pais> create(@Valid @RequestBody PaisDTO paisDTO){
        Pais pais = service.fromDTO(paisDTO);
        pais = service.create(pais);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
