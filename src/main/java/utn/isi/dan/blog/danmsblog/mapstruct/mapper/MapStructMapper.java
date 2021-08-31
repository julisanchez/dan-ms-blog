package utn.isi.dan.blog.danmsblog.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import utn.isi.dan.blog.danmsblog.domain.Articulo;
import utn.isi.dan.blog.danmsblog.domain.Calificacion;
import utn.isi.dan.blog.danmsblog.domain.Seccion;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloBasicoDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloFullDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloPostDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.CalificacionDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.SeccionDto;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    @Named("articuloToInt")
    static Integer articuloToInt(Articulo articulo) {
        return articulo.getId();
    }

    @Named("intToArticulo")
    static Articulo intToArticulo(Integer articuloId) {
        Articulo articulo = new Articulo();
        articulo.setId(articuloId);

        return articulo;
    }

    // Articulo

    ArticuloBasicoDto articuloToArticuloBasicoDto(Articulo articulo);

    Articulo articuloPostDtoToArticulo(ArticuloPostDto articuloPostDto);

    ArticuloFullDto articuloToArticuloFullDto(Articulo articulo);

    // Calificacion

    @Mapping(source = "articulo", target = "articuloId", qualifiedByName = "articuloToInt")
    CalificacionDto calificacionToCalificacionDto(Calificacion calificacion);

    @Mapping(source = "articuloId", target = "articulo", qualifiedByName = "intToArticulo")
    Calificacion calificacionDtoToCalificacion(CalificacionDto calificacionDto);

    // Seccion

    SeccionDto seccionToSeccionDto(Seccion seccion);

    Seccion seccionDtoToSeccion(SeccionDto seccionDto);
}
