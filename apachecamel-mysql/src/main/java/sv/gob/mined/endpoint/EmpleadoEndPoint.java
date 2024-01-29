package sv.gob.mined.endPoint;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import sv.gob.mined.modelo.EmpleadoModelo;
import sv.gob.mined.modelo.RespuestaServicio;

/**
 * Clase principal que contiene todos los EndPoint principales de la api.
 * @author Oliver González
 */
@Component
public class EmpleadoEndPoint extends RouteBuilder{

	/**
	 * Método centrado en mantener la configuración para la creación de los EndPoint
	 * que van a ser usado para la funcionalidad de la api.
	 */
	@Override
	public void configure() throws Exception {
		
		restConfiguration()
			.component("servlet")
			.bindingMode(RestBindingMode.auto)
			.apiContextPath("/api-doc")
            .apiProperty("api.title", "Apache Camel CRUD")
            .apiProperty("api.version", "1.0.0")
            .apiProperty("api.description", "API usando el framework Apache Camel para creación de un CRUD ")
            .apiProperty("base.path", "/localhost:8080/api - Servidor de Desarrollo");    
		
		rest("/empleado-endpoint").tag("CRUD").description("Endpoint ejemplos de un CRUD")
			.consumes(MediaType.APPLICATION_JSON_VALUE)
			.produces(MediaType.APPLICATION_JSON_VALUE)
			
			
			.get("/obtenerEmpleados").description("Obtener los Empleados")
				.outType(RespuestaServicio.class)
				.to("bean:empleadoBean?method=obtenerEmpleados()")
			
			.get("/obtenerEmpleadoPorId/{id}").description("Obtener el Empleado")
				.outType(RespuestaServicio.class)
				.param().name("id").type(RestParamType.path).description("Identificador del empleado").dataType("number").endParam()
				.to("bean:empleadoBean?method=obtenerEmpleadoPorId(${header.id})")
			
			.post("/crearEmpleado").description("Creación de Empleado")
				.type(EmpleadoModelo.class)
				.outType(RespuestaServicio.class)
				.param().name("empleado").type(RestParamType.body).description("Objecto con los valores a crear del empleado").dataType("EmpleadoModelo").endParam()
				.to("bean:empleadoBean?method=crearEmpleado(${body})")
			
			.put("/actualizarEmpleado").description("Actualización del empleado")
				.type(EmpleadoModelo.class)
				.outType(RespuestaServicio.class)
				.param().name("empleado").type(RestParamType.body).description("Objecto con los valores a actualizar del empleado").dataType("EmpleadoModelo").endParam()
				.to("bean:empleadoBean?method=actualizarEmpleado(${body})")
				
			.put("/actualizarDireccion").description("Actualiza la dirección del empleado")
				.type(EmpleadoModelo.class)
				.outType(RespuestaServicio.class)
				.param().name("empleado").type(RestParamType.body).description("Objecto con los valores a actualizar la direccion del empleado").dataType("EmpleadoModelo").endParam()
				.to("bean:empleadoBean?method=actualizarDireccionEmpleado(${body})")
				
			.delete("/eliminarEmpleado/{id}").description("Elimina el empleado")
				.outType(RespuestaServicio.class)
				.param().name("id").type(RestParamType.path).description("Identificador del empleado").dataType("number").endParam()
				.to("bean:empleadoBean?method=eliminarEmpleado(${header.id})");
		
		
		
	}

	
}
