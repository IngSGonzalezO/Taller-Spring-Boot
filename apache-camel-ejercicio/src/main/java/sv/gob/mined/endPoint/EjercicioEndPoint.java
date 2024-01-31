package sv.gob.mined.endPoint;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import sv.gob.mined.modelo.OperacionModelo;
import sv.gob.mined.modelo.Respuesta;

/**
 * Clase que contiene la lógica de los EndPoint de la API.
 */
@Component
public class EjercicioEndPoint extends RouteBuilder{

	/**
	 * Metodo principal encargado de tener la configuracion de los endPoint.
	 */
	@Override
	public void configure() throws Exception {
		
		restConfiguration()
			.component("servlet")
			.bindingMode(RestBindingMode.auto)
			.apiContextPath("/api-doc")
			.apiProperty("api.title", "Ejercicio de Apache Camel")
			.apiProperty("api.description", "Uso del Framework Apache Camel para saludar y realizar operaciones matematicas")
			.apiProperty("api.version", "1.0.0");
		
		rest("/ejercicio").tag("EndPoint_1").description("EndPoint para saludar a la persona")
			.consumes(MediaType.APPLICATION_JSON_VALUE)
			.produces(MediaType.APPLICATION_JSON_VALUE)
			
			.get("/saludar/{edad}").description("Edad y nombre requeridos")
				.outType(Respuesta.class)
				.param().name("edad").type(RestParamType.path).description("Edad de la persona").dataType("integer").required(true).endParam()
				.param().name("nombre").type(RestParamType.query).description("Nombre de la persona").dataType("string").required(true).endParam()
				.to("bean:ejercicioBean?method=saludarPersona(${header.nombre}, ${header.edad})")
				
			.get("/saludar").description("Nombre requerido y edad no")
				.outType(Respuesta.class)
				.param().name("edad").type(RestParamType.path).description("Edad de la persona").dataType("integer").required(false).endParam()
				.param().name("nombre").type(RestParamType.query).description("Nombre de la persona").dataType("string").required(true).endParam()
				.to("bean:ejercicioBean?method=saludarPersona(${header.nombre}, ${header.edad})");
		
		
		
		rest("/ejercicio").tag("EndPoint_2").description("EndPoint para las operaciones matematicas")
			.consumes(MediaType.APPLICATION_JSON_VALUE)
			.produces(MediaType.APPLICATION_JSON_VALUE)
			
			.post("/operacion").description("Realiza operaciones matematicas de multiplicacion, division y suma")
				.type(OperacionModelo.class)
				.outType(Respuesta.class)
				.param().name("operacion").type(RestParamType.body).description("Objecto con los campos para la operacion matematica").dataType("OperacionModelo").endParam()
				.to("bean:ejercicioBean?method=operacionMatematica(${body})");
		
	}

}
