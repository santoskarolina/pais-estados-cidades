package santos.karolina.consultaDeCidades.entities.DTO;

import santos.karolina.consultaDeCidades.entities.Pais;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PaisDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Nome do País é obrigatorio")
    private String nome;
    @NotEmpty(message = "Nome em Portuguêssdo País é obrigatorio")
    private String nomePt;
    @NotEmpty(message = "Sigla do País é obrigatorio")
    private String sigla;
    @NotNull(message = "Bacen é obrigatorio")
    private Integer bacen;

    public PaisDTO(){}

    public PaisDTO(Pais obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.nomePt = obj.getNomePt();
        this.sigla = obj.getSigla();
        this.bacen = obj.getBacen();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomePt() {
        return nomePt;
    }

    public void setNomePt(String nomePt) {
        this.nomePt = nomePt;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getBacen() {
        return bacen;
    }

    public void setBacen(Integer bacen) {
        this.bacen = bacen;
    }
}
