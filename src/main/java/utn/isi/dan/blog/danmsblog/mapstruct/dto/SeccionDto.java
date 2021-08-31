package utn.isi.dan.blog.danmsblog.mapstruct.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SeccionDto {
    private Integer id;

    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;

    @NotBlank(message = "El texto es obligatorio")
    @Size(min = 100, message = "Debe contener al menos 256 caracteres")
    private String texto;


    public SeccionDto() {
    }

    public SeccionDto(Integer id, String titulo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
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

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
