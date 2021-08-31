package utn.isi.dan.blog.danmsblog.mapstruct.dto;

import java.time.Instant;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticuloFullDto {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String autor;
    private Instant fechaPublicacion;
    private List<SeccionDto> secciones;
    private List<CalificacionDto> calificaciones;


    public ArticuloFullDto() {
    }

    public ArticuloFullDto(Integer id, String titulo, String descripcion, String autor, Instant fechaPublicacion, List<SeccionDto> secciones, List<CalificacionDto> calificaciones) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.secciones = secciones;
        this.calificaciones = calificaciones;
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

    public List<SeccionDto> getSecciones() {
        return this.secciones;
    }

    public void setSecciones(List<SeccionDto> secciones) {
        this.secciones = secciones;
    }

    public List<CalificacionDto> getCalificaciones() {
        return this.calificaciones;
    }

    public void setCalificaciones(List<CalificacionDto> calificaciones) {
        this.calificaciones = calificaciones;
    }
}