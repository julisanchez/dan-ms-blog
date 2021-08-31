package utn.isi.dan.blog.danmsblog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;

import utn.isi.dan.blog.danmsblog.dao.ArticuloRepository;
import utn.isi.dan.blog.danmsblog.dao.CalificacionRepository;
import utn.isi.dan.blog.danmsblog.domain.Articulo;
import utn.isi.dan.blog.danmsblog.domain.Calificacion;
import utn.isi.dan.blog.danmsblog.exception.ArticuloNotFoundException;
import utn.isi.dan.blog.danmsblog.exception.TituloAlreadyExistsException;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloBasicoDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloFullDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloPostDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.CalificacionDto;
import utn.isi.dan.blog.danmsblog.service.implement.ArticuloServiceImp;

@SpringBootTest
@Profile("testing")
public class ArticuloServiceImpTests {

    @Autowired
    ArticuloServiceImp articuloService;

    @MockBean
    ArticuloRepository articuloRepository;

    @MockBean
    CalificacionRepository calificacionRepository;

    ArticuloPostDto articuloPost;

    CalificacionDto calificacionDto;

    Articulo articulo;

    Calificacion calificacion;

    List<Articulo> articulosList;

    @BeforeEach
    void setUp() {
        articuloPost = new ArticuloPostDto();
        articuloPost.setTitulo("titulo");
        articuloPost.setSecciones(new ArrayList<>());

        calificacionDto = new CalificacionDto();
        calificacionDto.setArticuloId(1);

        articulo = new Articulo();
        articulo.setId(1);

        calificacion = new Calificacion();
        calificacion.setArticulo(articulo);

        articulosList = new ArrayList<>();

    }

    @Test
    void testObtenerArticulos() {
        when(articuloRepository.findAll(any(Sort.class))).thenReturn(articulosList);

        List<ArticuloBasicoDto> articulosRes = articuloService.obtenerArticulos();

        assertEquals(articulosList.size(), articulosRes.size());

        verify(articuloRepository, times(1)).findAll(any(Sort.class));
    }

    @Test
    void testObtenerArticuloEncontrado() {
        when(articuloRepository.findById(1)).thenReturn(Optional.of(articulo));

        ArticuloFullDto articuloRes = articuloService.obtenerArticulo(1);

        assertNotNull(articuloRes);

        verify(articuloRepository, times(1)).findById(1);
    }

    @Test
    void testObtenerArticuloNoEncontrado() {
        when(articuloRepository.findById(-1)).thenReturn(Optional.empty());

        assertThrows(ArticuloNotFoundException.class, () -> articuloService.obtenerArticulo(-1));

        verify(articuloRepository, times(1)).findById(-1);
    }

    @Test
    void testPublicarArticuloTituloInexistente() {
        when(articuloRepository.existsByTitulo(anyString())).thenReturn(false);
        when(articuloRepository.save(any(Articulo.class))).thenReturn(articulo);

        ArticuloFullDto articuloRes = articuloService.publicarArticulo(articuloPost);

        assertNotNull(articuloRes);

        verify(articuloRepository, times(1)).save(argThat((articulo) -> articulo.getFechaPublicacion() != null));
    }

    @Test
    void testPublicarArticuloTituloExistente() {
        when(articuloRepository.existsByTitulo(anyString())).thenReturn(true);

        assertThrows(TituloAlreadyExistsException.class, () -> articuloService.publicarArticulo(articuloPost));

        verify(articuloRepository, times(1)).existsByTitulo(anyString());
    }

    @Test
    void testPublicarCalificacionDeArticuloExistente() {
        when(articuloRepository.existsById(anyInt())).thenReturn(true);
        when(calificacionRepository.save(any(Calificacion.class))).thenReturn(calificacion);

        CalificacionDto calificacionRes = articuloService.publicarCalificacion(calificacionDto);

        assertNotNull(calificacionRes);

        verify(articuloRepository, times(1)).existsById(anyInt());
        verify(calificacionRepository, times(1)).save(any(Calificacion.class));
    }

    @Test
    void testPublicarCalificacionDeArticuloInexistente() {
        when(articuloRepository.existsById(anyInt())).thenReturn(false);

        assertThrows(ArticuloNotFoundException.class, () -> articuloService.publicarCalificacion(calificacionDto));

        verify(articuloRepository, times(1)).existsById(anyInt());
        verify(calificacionRepository, times(0)).save(any(Calificacion.class));
    }
}
