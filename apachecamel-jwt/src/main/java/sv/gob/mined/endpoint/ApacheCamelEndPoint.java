package sv.gob.mined.endpoint;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import sv.gob.mined.modelo.RespuestaServicio;

@Component
public class ApacheCamelEndPoint extends RouteBuilder{
	
	@Override
	public void configure() throws Exception {
		
		restConfiguration()
			.component("servlet")
			.bindingMode(RestBindingMode.auto);
		
		
		rest("/apachecamel-endpoint")
			.consumes("application/json")
			.produces(MediaType.APPLICATION_JSON_VALUE)
			
			.get("/hola")
				.outType(RespuestaServicio.class)
				.to("bean:getBean");
				
			
		
	}

}
