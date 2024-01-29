package sv.gob.mined.servicios;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("mined".equals(username)) {
			return new User("apache", "$2a$12$x1hYGl/XlaLOmVhtIQCwtuZ5kOZC7BxgdpITMBAsrme2xRR3IlHTO",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Usuario no encontrado: " + username);
		}
	}
}
