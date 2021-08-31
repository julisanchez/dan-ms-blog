package utn.isi.dan.blog.danmsblog.domain;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICULO")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TITULO", unique = true, nullable = false)
    private String titulo;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "AUTOR", nullable = false)
    private String autor;

    @Column(name = "FECHA_PUBLICACION", nullable = false, columnDefinition = "TIMESTAMP")
    private Instant fechaPublicacion;

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL)
    private List<Seccion> secciones;

    @OneToMany(mappedBy = "articulo")
    private List<Calificacion> calificaciones;

    public Articulo() {
    }

    public Articulo(Integer id, String titulo, String descripcion, String autor, Instant fechaPublicacion,
            List<Seccion> secciones, List<Calificacion> calificaciones) {
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

    public List<Seccion> getSecciones() {
        return this.secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }

    public List<Calificacion> getCalificaciones() {
        return this.calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

}
