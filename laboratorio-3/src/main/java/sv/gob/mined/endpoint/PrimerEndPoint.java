package sv.gob.mined.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/primer-endpoint")
public class PrimerEndPoint {
	
	
	@GetMapping(path="/index")
	public String primerEndpoint() {
		return "Hola Mundo ";
	}
	
	
	
}
