package utn.isi.dan.blog.danmsblog.mapstruct.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CalificacionDto {

    private Integer id;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private Integer valor;
    
    private String comentario;

    @NotNull
    private Integer articuloId;


    public CalificacionDto() {
    }

    public CalificacionDto(Integer id, Integer valor, String comentario, Integer articuloId) {
        this.id = id;
        this.valor = valor;
        this.comentario = comentario;
        this.articuloId = articuloId;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValor() {
        return this.valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getArticuloId() {
        return this.articuloId;
    }

    public void setArticuloId(Integer articuloId) {
        this.articuloId = articuloId;
    }

}
