package utn.isi.dan.blog.danmsblog.mapstruct.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArticuloPostDto {

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "La descripcion es obligatoria")
    private String descripcion;

    @NotBlank(message = "El autor es obligatorio")
    private String autor;

    @NotNull(message = "Debe contener al menos una seccion")
    @Size(min = 1, message = "Debe contener al menos una seccion")
    private List<@Valid SeccionDto> secciones;
    

    public ArticuloPostDto() {
    }

    public ArticuloPostDto(String titulo, String descripcion, String autor, List<SeccionDto> secciones) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.autor = autor;
        this.secciones = secciones;
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

    public List<SeccionDto> getSecciones() {
        return this.secciones;
    }

    public void setSecciones(List<SeccionDto> secciones) {
        this.secciones = secciones;
    }

}
