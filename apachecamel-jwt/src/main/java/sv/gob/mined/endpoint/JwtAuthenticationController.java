package sv.gob.mined.endpoint;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import sv.gob.mined.modelo.JwtRequest;
import sv.gob.mined.modelo.JwtResponse;

@Component
public class JwtAuthenticationController extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		restConfiguration()
		.component("servlet")
		.bindingMode(RestBindingMode.auto);
	
	
	rest()
		.consumes("application/json")
		.produces(MediaType.APPLICATION_JSON_VALUE)
		
		.post("/authenticate")
			.type(JwtRequest.class)
			.outType(JwtResponse.class)
			.param().name("autenticación").type(RestParamType.body).description("Objecto de autenticación").dataType("JwtRequest").endParam()
			.to("bean:authenticationBean?method=createAuthenticationToken(${body})");
		
	}
}
