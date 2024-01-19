package sv.gob.mined;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/**
 * Clase principal de la API
 * 
 * @author Oliver Gonzalez
 */
@SpringBootApplication
@EntityScan("sv.gob.mined.entidades")
public class Laboratorio01Application {

	/**
	 * Metodo principal que permite iniciar la api construida. 
	 * @param args Argumento propio de la clase main.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Laboratorio01Application.class, args);
	}
	

}
