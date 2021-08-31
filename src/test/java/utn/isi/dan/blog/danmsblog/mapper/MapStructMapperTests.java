package utn.isi.dan.blog.danmsblog.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import utn.isi.dan.blog.danmsblog.domain.Articulo;
import utn.isi.dan.blog.danmsblog.domain.Calificacion;
import utn.isi.dan.blog.danmsblog.domain.Seccion;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloBasicoDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloFullDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloPostDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.CalificacionDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.SeccionDto;
import utn.isi.dan.blog.danmsblog.mapstruct.mapper.MapStructMapper;

@SpringBootTest
public class MapStructMapperTests {

    @Autowired
    MapStructMapper mapper;

    static ArticuloBasicoDto articuloBasico;

    static Articulo articulo;

    static ArticuloPostDto articuloPost;

    static Seccion seccion;

    static SeccionDto seccionDto;

    static Calificacion calificacion;

    static CalificacionDto calificacionDto;

    @BeforeAll
    static void setUp() {
        articuloBasico = new ArticuloBasicoDto(1, "titulo", "descripcion", "autor", Instant.now());

        articulo = new Articulo(1, "titulo", "descripcion", "autor", Instant.now(), new ArrayList<>(),
                new ArrayList<>());

        articuloPost = new ArticuloPostDto("titulo", "descripcion", "autor", new ArrayList<>());

        seccion = new Seccion(1, "seccion", "texto", articulo);

        seccionDto = new SeccionDto(1, "seccion", "texto");

        calificacion = new Calificacion(1, 3, "comentario", articulo);

        calificacionDto = new CalificacionDto(1, 2, "comentario", 2);
    }

    @Test
    void articuloToArticuloBasicoDto() {
        ArticuloBasicoDto res = mapper.articuloToArticuloBasicoDto(articulo);

        assertEquals(articulo.getId(), res.getId());
        assertEquals(articulo.getTitulo(), res.getTitulo());
        assertEquals(articulo.getDescripcion(), res.getDescripcion());
        assertEquals(articulo.getAutor(), res.getAutor());
        assertEquals(articulo.getFechaPublicacion(), res.getFechaPublicacion());
    }

    @Test
    void articuloPostDtoToArticulo() {
        Articulo res = mapper.articuloPostDtoToArticulo(articuloPost);

        assertEquals(articuloPost.getTitulo(), res.getTitulo() + "");
        assertEquals(articuloPost.getDescripcion(), res.getDescripcion());
        assertEquals(articuloPost.getSecciones().size(), res.getSecciones().size());
        assertEquals(articuloPost.getAutor(), res.getAutor());
    }

    @Test
    void articuloToArticuloFullDto() {
        ArticuloFullDto res = mapper.articuloToArticuloFullDto(articulo);

        assertEquals(articulo.getId(), res.getId());
        assertEquals(articulo.getDescripcion(), res.getDescripcion());
        assertEquals(articulo.getTitulo(), res.getTitulo());
        assertEquals(articulo.getAutor(), res.getAutor());
        assertEquals(articulo.getFechaPublicacion(), res.getFechaPublicacion());
        assertEquals(articulo.getCalificaciones().size(), res.getCalificaciones().size());
        assertEquals(articulo.getSecciones().size(), res.getSecciones().size());
    }

    @Test
    void seccionToSeccionDto() {
        SeccionDto res = mapper.seccionToSeccionDto(seccion);

        assertEquals(seccion.getId(), res.getId());
        assertEquals(seccion.getTexto(), res.getTexto());
        assertEquals(seccion.getTitulo(), res.getTitulo());
    }

    @Test
    void calificacionToCalificacionDto() {
        CalificacionDto res = mapper.calificacionToCalificacionDto(calificacion);

        assertEquals(calificacion.getId(), res.getId());
        assertEquals(calificacion.getValor(), res.getValor());
        assertEquals(calificacion.getComentario(), res.getComentario());
        assertEquals(calificacion.getArticulo().getId(), res.getArticuloId());
    }

    @Test
    void calificacionDtoToCalificacion() {
        Calificacion res = mapper.calificacionDtoToCalificacion(calificacionDto);

        assertEquals(calificacionDto.getArticuloId(), res.getArticulo().getId());
    }
}
