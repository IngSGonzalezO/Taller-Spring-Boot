package sv.gob.mined.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.Customizer;

/**
 * Clase que mantiene la configuración para la autenticación basica.
 * @author Oliver Gonzalez
 */
@Configuration
public class SeguridadConfiguracion {

	/**
	 * Metodo encargado de encriptar la contraseña configurada.
	 * @return Retorna la contraseña encriptada.
	 */
	@Bean
	PasswordEncoder passwordEncored(){
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Metodo centrado en tener la configuración de acceso a los EndPoint de la API.
	 * @param http Objecto que contienen la configuración de acceso a los EndPoint.
	 * @return Retorna el objecto con los permiso para las URL.
	 * @throws Exception Manejo de la excepciones de método general.
	 */
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests((authorize) -> {
            authorize
            .anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }

	/**
	 * Metodo centrado en realizar la configuración de las credenciales para la autenticación básica.
	 * @return Retorna las credenciales de acceso configuradas.
	 */
    @Bean
    UserDetailsService userDetailsService() {

        UserDetails admin = User.builder().username("apache").password(passwordEncored().encode("camel"))
                .build();

        return new InMemoryUserDetailsManager(admin);
    }
	
}
