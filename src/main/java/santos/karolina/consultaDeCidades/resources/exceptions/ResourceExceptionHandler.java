package santos.karolina.consultaDeCidades.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import santos.karolina.consultaDeCidades.services.exceptions.NotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandarError> notFound(NotFoundException e, HttpServletRequest request){
        String error = "Erro de busca";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError standarError = new StandarError(Instant.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(standarError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandarError> validation(MethodArgumentNotValidException e , HttpServletRequest request){
        String error = "Erro de validação";
        String message = "Campos incorretos";
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Validation validation = new Validation(Instant.now(), status.value(), error, message, request.getRequestURI());

        for(FieldError x : e.getBindingResult().getFieldErrors()){
            validation.addErros(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(validation);
    }
}
