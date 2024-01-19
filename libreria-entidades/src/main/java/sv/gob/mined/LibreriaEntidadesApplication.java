package sv.gob.mined;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("sv.gob.mined.entidades")
public class LibreriaEntidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaEntidadesApplication.class, args);
	}

}
