package utn.isi.dan.blog.danmsblog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.jdbc.Sql;

import utn.isi.dan.blog.danmsblog.dao.CalificacionRepository;

@SpringBootTest
@Profile("testing")
@Sql({ "/articulos.sql" })
public class CalificacionRepositoryTests {
    
    @Autowired
    CalificacionRepository calificacionRepository;
}
