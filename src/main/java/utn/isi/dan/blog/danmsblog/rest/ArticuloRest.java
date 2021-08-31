package utn.isi.dan.blog.danmsblog.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloBasicoDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloFullDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.ArticuloPostDto;
import utn.isi.dan.blog.danmsblog.mapstruct.dto.CalificacionDto;
import utn.isi.dan.blog.danmsblog.service.IArticuloService;

@RestController
@Validated
@CrossOrigin
@RequestMapping("api/articulo")
@Api(value = "BlogRest")
public class ArticuloRest {

    @Autowired
    private IArticuloService blogService;

    @GetMapping
    @ApiOperation(value = "Devuelve todos los articulos")
    public ResponseEntity<List<ArticuloBasicoDto>> obtenerArticulos() {
        return ResponseEntity.ok(blogService.obtenerArticulos());
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Devuelve un unico articulo por su id")
    public ResponseEntity<ArticuloFullDto> obtenerArticulo(@PathVariable Integer id) {
        return ResponseEntity.ok(blogService.obtenerArticulo(id));
    }

    @PostMapping
    @ApiOperation(value = "Publica un articulo")
    public ResponseEntity<ArticuloFullDto> publicarArticulo(@Valid @RequestBody ArticuloPostDto articulo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.publicarArticulo(articulo));
    }

    @PostMapping(path = "/{id}/calificacion")
    @ApiOperation(value = "Publica una calificacion")
    public ResponseEntity<CalificacionDto> publicarCalificacion(@Valid @RequestBody CalificacionDto calificacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.publicarCalificacion(calificacion));
    }
}
