package utn.isi.dan.blog.danmsblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArticuloNotFoundException extends RuntimeException {
    private String detail;

    private ArticuloNotFoundException() {
        super("Articulo no encontrado");
    }

    public ArticuloNotFoundException(Integer id) {
        this();
        this.detail = "Invalid articulo id: " + id;
    }

    public ArticuloNotFoundException(String detail) {
        this();
        this.detail = detail;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
