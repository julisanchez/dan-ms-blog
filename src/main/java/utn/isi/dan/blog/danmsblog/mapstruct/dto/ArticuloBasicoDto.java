package utn.isi.dan.blog.danmsblog.mapstruct.dto;

import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloBasicoDto {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String autor;
    private Instant fechaPublicacion;


    public ArticuloBasicoDto() {
    }

    public ArticuloBasicoDto(Integer id, String titulo, String descripcion, String autor, Instant instant) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaPublicacion = instant;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Instant getFechaPublicacion() {
        return this.fechaPublicacion;
    }

    public void setFechaPublicacion(Instant fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

}
