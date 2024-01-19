package sv.gob.mined;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("sv.gob.mined.entidades")
public class Laboratorio01Application {

	public static void main(String[] args) {
		SpringApplication.run(Laboratorio01Application.class, args);
	}
	

}
