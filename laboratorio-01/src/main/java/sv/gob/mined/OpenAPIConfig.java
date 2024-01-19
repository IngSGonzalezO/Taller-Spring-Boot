package sv.gob.mined;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

/**
 * Clase que mantiene la configuración para personalizar el Swagger.
 * @author Oliver Gonzalez
 */
@Configuration
public class OpenAPIConfig {

  @Value("${api.openapi.dev-url}")
  private String desUrl;

  /**
   * Metodo que mantiene la lógica para personalizar el swagger de la API.
   * @return Retorna un objecto con los valores personalizados para el swagger.
   */
  @Bean
  OpenAPI myOpenAPI() {
    Server desServidor = new Server();
    desServidor.setUrl(desUrl);
    desServidor.setDescription("URL del servidor de desarrollo");


    License mitLicense = new License().name("Laboratorio-01");

    Info info = new Info()
        .title("Laboratorio-01 API")
        .version("3.0")
        .description("API Taller de Spring Boot.")
        .license(mitLicense);

    return new OpenAPI().info(info).servers(List.of(desServidor));
  }
}
