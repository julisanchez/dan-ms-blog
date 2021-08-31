package utn.isi.dan.blog.danmsblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableAspectJAutoProxy
@CrossOrigin
public class DanMsBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(DanMsBlogApplication.class, args);
	}

}
