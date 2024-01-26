package sv.gob.mined.endpoint;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import sv.gob.mined.modelo.RespuestaServicio;

@Component
public class EmpleadoEndPoint extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		
		restConfiguration()
			.component("servlet")
			.bindingMode(RestBindingMode.auto);
		
		rest("/empleado-endpoint")
			.consumes(MediaType.APPLICATION_JSON_VALUE)
			.produces(MediaType.APPLICATION_JSON_VALUE)
			
			
			.get("/obtenerEmpleados")
				.outType(RespuestaServicio.class)
				.to("bean:empleadoBean?method=obtenerEmpleados()")
			
			.get("/obtenerEmpleadoPorId/{id}")
				.outType(RespuestaServicio.class)
				.param().name("id").type(RestParamType.path).description("Identificador del empleado").dataType("long").endParam()
				.to("bean:empleadoBean?method=obtenerEmpleadoPorId(${header.id})");
		
	}

	
}
