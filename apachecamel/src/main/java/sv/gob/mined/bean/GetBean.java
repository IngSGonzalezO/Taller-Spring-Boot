package sv.gob.mined.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import sv.gob.mined.modelo.EmpleadoModelo;
import sv.gob.mined.modelo.RespuestaServicio;

@Component
public class GetBean implements Processor {

	public RespuestaServicio hola(String nombre, int edad) {
		return new RespuestaServicio("Hola, Mundo ".concat(nombre).concat(" tiene ") + edad);
	}
	
	public RespuestaServicio saludarModelo(EmpleadoModelo empleado) {
		
		String nombre = empleado.getNombre();
		Long id = empleado.getIdentificador();
		
		return new RespuestaServicio("Hola, ".concat(nombre).concat(" tiene asignado el valor ") + id);
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		
	    EmpleadoModelo empleado = exchange.getIn().getBody(EmpleadoModelo.class);

	    String nombre = empleado.getNombre();
	    Long id = empleado.getIdentificador();

	    RespuestaServicio respuesta = new RespuestaServicio("Hola " + nombre + ", tiene el identificador " + id);

	    exchange.getMessage().setBody(respuesta);
		
	}
	
	
	
}
