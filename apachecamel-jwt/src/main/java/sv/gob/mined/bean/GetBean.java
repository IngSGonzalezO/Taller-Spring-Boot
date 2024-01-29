package sv.gob.mined.bean;

import org.springframework.stereotype.Component;

import sv.gob.mined.modelo.RespuestaServicio;

@Component
public class GetBean {

	public RespuestaServicio hola() {
		return new RespuestaServicio("Hola, logro usa JwT con Apache Camel - Spring Boot");
	}
	
	
	
}
