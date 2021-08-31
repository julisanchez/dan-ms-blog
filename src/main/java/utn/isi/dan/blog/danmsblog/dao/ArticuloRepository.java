package utn.isi.dan.blog.danmsblog.dao;

import org.springframework.stereotype.Repository;

import utn.isi.dan.blog.danmsblog.domain.Articulo;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
    boolean existsByTitulo(String titulo);
}
