package sv.gob.mined.bean;

import org.springframework.stereotype.Component;

import sv.gob.mined.modelo.EmpleadoModelo;
import sv.gob.mined.modelo.RespuestaServicio;

@Component
public class GetBean {

	public RespuestaServicio hola(String nombre, int edad) {
		return new RespuestaServicio("Hola, Mundo ".concat(nombre).concat(" tiene ") + edad);
	}
	
	public RespuestaServicio saludarModelo(EmpleadoModelo empleado) {
		
		String nombre = empleado.getNombre();
		Long id = empleado.getIdentificador();
		
		return new RespuestaServicio("Hola, ".concat(nombre).concat(" tiene asignado el valor ") + id);
	}
	
	
	
}
