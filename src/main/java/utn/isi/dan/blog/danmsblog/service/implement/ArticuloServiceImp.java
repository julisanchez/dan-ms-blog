package utn.isi.dan.blog.danmsblog.service.implement;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import utn.isi.dan.blog.danmsblog.mapstruct.mapper.MapStructMapper;
import utn.isi.dan.blog.danmsblog.service.IArticuloService;

@Service
public class ArticuloServiceImp implements IArticuloService {

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    CalificacionRepository calificacionRepository;

    @Autowired
    private MapStructMapper mapper;

    @Override
    public List<ArticuloBasicoDto> obtenerArticulos() {
        List<Articulo> articulos = articuloRepository.findAll(sortByPublishDateDesc());

        return articulos.stream().map(mapper::articuloToArticuloBasicoDto).collect(Collectors.toList());
    }

    @Override
    public ArticuloFullDto obtenerArticulo(Integer id) {
        Articulo articulo = articuloRepository.findById(id).orElseThrow(() -> new ArticuloNotFoundException(id));

        return mapper.articuloToArticuloFullDto(articulo);
    }

    @Override
    public ArticuloFullDto publicarArticulo(ArticuloPostDto articuloPostDto) {
        if (articuloRepository.existsByTitulo(articuloPostDto.getTitulo()))
            throw new TituloAlreadyExistsException(articuloPostDto.getTitulo());

        final Articulo articulo = mapper.articuloPostDtoToArticulo(articuloPostDto);

        articulo.setFechaPublicacion(Instant.now());
        articulo.getSecciones().forEach((seccion) -> seccion.setArticulo(articulo));

        Articulo articuloSaved = articuloRepository.save(articulo);

        return mapper.articuloToArticuloFullDto(articuloSaved);
    }

    @Override
    public CalificacionDto publicarCalificacion(CalificacionDto calificacionDto) {
        boolean articuloExists = articuloRepository.existsById(calificacionDto.getArticuloId());

        if (!articuloExists)
            throw new ArticuloNotFoundException(calificacionDto.getArticuloId());

        Calificacion calificacion = mapper.calificacionDtoToCalificacion(calificacionDto);
        calificacion = calificacionRepository.save(calificacion);

        return mapper.calificacionToCalificacionDto(calificacion);
    }

    private Sort sortByPublishDateDesc() {
        return Sort.by(Sort.Direction.DESC, "fechaPublicacion");
    }

}
