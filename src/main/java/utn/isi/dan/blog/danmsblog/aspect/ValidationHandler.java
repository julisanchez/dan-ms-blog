package utn.isi.dan.blog.danmsblog.aspect;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import utn.isi.dan.blog.danmsblog.exception.ArticuloNotFoundException;
import utn.isi.dan.blog.danmsblog.exception.TituloAlreadyExistsException;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArticuloNotFoundException.class)
    public ResponseEntity<Object> handleArticuloNotFound(ArticuloNotFoundException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse("articulo-not-found", ex.getLocalizedMessage(), ex.getDetail());

        return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TituloAlreadyExistsException.class)
    public ResponseEntity<Object> handleTitleAlreadyExists(TituloAlreadyExistsException ex, WebRequest request) {
        ErrorResponse response = new ErrorResponse("titulo-already-exists", ex.getLocalizedMessage(), ex.getDetail());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

}
