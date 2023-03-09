package cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "cat.itacademy.barcelonactiva.liz.montse.s04.t02.n02.model.domain")
public class S04T02N02LizMontseApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N02LizMontseApplication.class, args);
	}

}
