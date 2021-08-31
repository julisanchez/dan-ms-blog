package utn.isi.dan.blog.danmsblog.rest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import utn.isi.dan.blog.danmsblog.exception.ArticuloNotFoundException;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloBasicoDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloFullDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloPostDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.CalificacionDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.SeccionDto;
import utn.isi.dan.blog.danmsblog.service.IArticuloService;

@SpringBootTest
public class ArticuloRestTests {

    @Autowired
    ArticuloRest articuloRest;

    @MockBean
    IArticuloService articuloService;

    ArticuloPostDto articuloValido;

    ArticuloPostDto articuloInvalido;

    ArticuloPostDto articuloConSeccionInvalida;

    CalificacionDto calificacionValida;

    CalificacionDto calificacionInvalida;

    List<ArticuloBasicoDto> articulosList;

    ArticuloFullDto articuloFullDto;

    @BeforeEach
    void setUp() {
        List<SeccionDto> secciones = new ArrayList<>();

        secciones.add(new SeccionDto(null, "titulo seccion",
                "Ullamco cillum elit adipisicing minim. Nulla anim irure veniam culpa ut elit. Exercitation quis tempor ut aliquip nisi proident culpa. Nulla anim dolor ea quis ad ut."));

        articuloValido = new ArticuloPostDto("titulo", "descripcion", "autor", secciones);

        articuloInvalido = new ArticuloPostDto();

        List<SeccionDto> seccionesInvalidas = new ArrayList<>();

        seccionesInvalidas.add(new SeccionDto());

        articuloConSeccionInvalida = new ArticuloPostDto("titulo", "descripcion", "autor", seccionesInvalidas);

        calificacionValida = new CalificacionDto(null, 4, "comentario", 1);

        calificacionInvalida = new CalificacionDto();

        articulosList = new ArrayList<>();

        articulosList.add(new ArticuloBasicoDto(1, "titulo", null, null, null));

        articulosList.add(new ArticuloBasicoDto(1, "titulo 2", null, null, null));

        articuloFullDto = new ArticuloFullDto(1, "titulo", null, null, null, secciones, null);
    }

    @Test
    void testObtenerArticulos() {
        when(articuloService.obtenerArticulos()).thenReturn(articulosList);

        ResponseEntity<List<ArticuloBasicoDto>> articulosRes = articuloRest.obtenerArticulos();

        assertEquals(HttpStatus.SC_OK, articulosRes.getStatusCode().value());
        assertArrayEquals(articulosList.toArray(), articulosRes.getBody().toArray());
    }

    @Test
    void testObtenerArticuloExistente() {
        when(articuloService.obtenerArticulo(1)).thenReturn(articuloFullDto);

        ResponseEntity<ArticuloFullDto> articuloRes = articuloRest.obtenerArticulo(1);

        assertEquals(HttpStatus.SC_OK, articuloRes.getStatusCode().value());
        assertEquals(articuloFullDto, articuloRes.getBody());
    }

    @Test
    void testObtenerArticuloInexistente() {
        when(articuloService.obtenerArticulo(-1)).thenThrow(new ArticuloNotFoundException(-1));

        assertThrows(ArticuloNotFoundException.class, () -> articuloRest.obtenerArticulo(-1));
    }

    @Test
    void testPublicarArticuloValido() {
        when(articuloService.publicarArticulo(articuloValido)).thenReturn(articuloFullDto);
        ResponseEntity<ArticuloFullDto> articuloRes = articuloRest.publicarArticulo(articuloValido);

        assertEquals(HttpStatus.SC_CREATED, articuloRes.getStatusCode().value());
        assertEquals(articuloFullDto, articuloRes.getBody());
    }

    @Test
    void testPublicarArticuloInvalido() {
        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
            articuloRest.publicarArticulo(articuloInvalido);
        });

        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();

        assertEquals(4, violations.size());
    }

    @Test
    void testPublicarCalificacionValida() {
        when(articuloService.publicarCalificacion(calificacionValida)).thenReturn(calificacionValida);

        ResponseEntity<CalificacionDto> calificacionRes = articuloRest.publicarCalificacion(calificacionValida);

        assertEquals(HttpStatus.SC_CREATED, calificacionRes.getStatusCode().value());
        assertEquals(calificacionValida, calificacionRes.getBody());
    }

    @Test
    void testPublicarCalificacionInvalida() {
        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> {
            articuloRest.publicarCalificacion(calificacionInvalida);
        });

        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();

        assertEquals(2, violations.size());
    }

}
