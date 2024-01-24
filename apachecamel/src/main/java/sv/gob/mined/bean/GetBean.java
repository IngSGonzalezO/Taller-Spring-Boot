package sv.gob.mined.bean;

import org.springframework.stereotype.Component;

import sv.gob.mined.modelo.RespuestaServicio;

@Component
public class GetBean {

	public RespuestaServicio hola(String nombre, int edad) {
		return new RespuestaServicio("Hola, Mundo ".concat(nombre).concat(" tiene ") + edad);
	}
	
}
