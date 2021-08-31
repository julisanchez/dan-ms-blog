package utn.isi.dan.blog.danmsblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class TituloAlreadyExistsException extends RuntimeException {
    private String detail;

    private TituloAlreadyExistsException() {
        super("El titulo ya existe");
    }

    public TituloAlreadyExistsException(String titulo) {
        this();
        this.detail = "Title \"" + titulo + "\" already exists";
    }


    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

 
}
