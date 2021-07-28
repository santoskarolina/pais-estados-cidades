package santos.karolina.consultaDeCidades.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Validation extends StandarError{

    private List<FieldMEssage> listaDeErros = new ArrayList<>();

    public Validation(Instant timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMEssage> getListaDeErros() {
        return listaDeErros;
    }

    public void setListaDeErros(List<FieldMEssage> listaDeErros) {
        this.listaDeErros = listaDeErros;
    }

    public void addErros(String nome, String mensagem){
        listaDeErros.add(new FieldMEssage(nome, mensagem));
    }
}
