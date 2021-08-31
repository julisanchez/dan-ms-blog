package utn.isi.dan.blog.danmsblog.service;

import java.util.List;

import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloBasicoDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloFullDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloPostDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.CalificacionDto;

public interface IArticuloService {

    public List<ArticuloBasicoDto> obtenerArticulos();

    public ArticuloFullDto obtenerArticulo(Integer id);

    public ArticuloFullDto publicarArticulo(ArticuloPostDto articulo);

    public CalificacionDto publicarCalificacion(CalificacionDto calificacion);

}
