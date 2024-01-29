package sv.gob.mined.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import sv.gob.mined.configuracion.JwtTokenUtil;
import sv.gob.mined.modelo.JwtRequest;
import sv.gob.mined.modelo.JwtResponse;
import sv.gob.mined.servicios.JwtUserDetailsService;

@Component
public class AuthenticationBean {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	public JwtResponse createAuthenticationToken(JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return new JwtResponse(token);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USUARIO_DISHABILITADO", e);
		} catch (BadCredentialsException e) {
			throw new Exception("CREDENCIALES_INVALIDAS", e);
		}
	}
	
}
