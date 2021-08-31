package utn.isi.dan.blog.danmsblog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Profile("testing")
@Sql({ "/articulos.sql" })
public class ArticuloRepositoryTests {

    @Autowired
    ArticuloRepositoryTests articuloRepository;
}
