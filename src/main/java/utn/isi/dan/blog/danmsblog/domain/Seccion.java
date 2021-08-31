package utn.isi.dan.blog.danmsblog.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "TEXTO", length = 1024, nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "ARTICULO_ID",nullable = false)
    private Articulo articulo;

    public Seccion() {
    }

    public Seccion(Integer id, String titulo, String texto, Articulo articulo) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
        this.articulo = articulo;
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

    public Articulo getArticulo() {
        return this.articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

}
