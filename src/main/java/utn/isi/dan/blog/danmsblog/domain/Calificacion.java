package utn.isi.dan.blog.danmsblog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "COMENTARIO")
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "ARTICULO_ID", nullable = false)
    private Articulo articulo;

    public Calificacion() {
    }

    public Calificacion(Integer id, Integer valor, String comentario, Articulo articulo) {
        this.id = id;
        this.valor = valor;
        this.comentario = comentario;
        this.articulo = articulo;
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

    public Articulo getArticulo() {
        return this.articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

}
