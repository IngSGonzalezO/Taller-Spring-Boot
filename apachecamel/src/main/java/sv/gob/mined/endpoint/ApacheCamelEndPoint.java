package sv.gob.mined.endpoint;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import sv.gob.mined.bean.GetBean;
import sv.gob.mined.modelo.EmpleadoModelo;
import sv.gob.mined.modelo.RespuestaServicio;

@Component
public class ApacheCamelEndPoint extends RouteBuilder{
	
	@Value("${camel.servlet.mapping.context-path}")
	private String contextPath;
	
	@Override
	public void configure() throws Exception {
		
		restConfiguration()
			.component("servlet")
			.contextPath(contextPath.substring(0, contextPath.length()-2))
			.bindingMode(RestBindingMode.auto);
		
		
		rest("/apachecamel-endpoint")
			.consumes("application/json")
			.produces(MediaType.APPLICATION_JSON_VALUE)
			
			.get("/path/{nombre}/{edad}")
				.outType(RespuestaServicio.class)
				.param().name("nombre").type(RestParamType.path).description("Nombre el usuario").dataType("string").required(false).endParam()
				.param().name("edad").type(RestParamType.path).description("Edad").dataType("integer").required(false).endParam()
				.to("bean:getBean?method=hola(${header.nombre}, ${header.edad})")
				
			.get("/query")
				.outType(RespuestaServicio.class)
				.param().name("nombre").type(RestParamType.query).description("Nombre el usuario").dataType("string").required(false).endParam()
				.param().name("edad").type(RestParamType.query).description("Edad").dataType("integer").required(false).endParam()
				.to("direct:hola")
				
			.post("/post")
				.type(EmpleadoModelo.class)
				.outType(RespuestaServicio.class)
				.param().name("empleado").type(RestParamType.body).description("Objecto de empleado").dataType("EmpleadoModelo").endParam()
				.to("direct:saludar")
			 
			.put("/put")
				.type(EmpleadoModelo.class)
				.outType(RespuestaServicio.class)
				.param().name("empleado").type(RestParamType.body).description("Objecto de empleado").dataType("EmpleadoModelo").endParam()
				.to("direct:saludar");
			
		from("direct:hola")
			.bean(GetBean.class, "hola(${header.nombre}, ${header.edad})");
		
		from("direct:saludar")
			.bean(GetBean.class, "saludarModelo(${body})");
		
	}

}
