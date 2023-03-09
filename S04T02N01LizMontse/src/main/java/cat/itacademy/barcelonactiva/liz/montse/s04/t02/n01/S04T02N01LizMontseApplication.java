package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Per connectar-se a la base de dades H2: http://localhost:8080/h2-console
 */
@SpringBootApplication
@EntityScan(basePackages = "cat.itacademy.barcelonactiva.liz.montse.s04.t02.n01.model.domain")
public class S04T02N01LizMontseApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N01LizMontseApplication.class, args);
	}

}
