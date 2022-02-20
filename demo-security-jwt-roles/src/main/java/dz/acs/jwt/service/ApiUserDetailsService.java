package dz.acs.jwt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 * ApiUserDetailsService
 * @author ataibi
 *
 */
@Service
public class ApiUserDetailsService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) 
			 throws UsernameNotFoundException {
		if("elit".equals(username)) {
			//(username,password) => ("elit","elit")
			return new User("elit", "$2a$10$ePJQH2zHIvEE/RCotC/pq.ScOg8oAS0YIZ73pZq2dc1CDjC8oxMK.",
					 new ArrayList<GrantedAuthority>( List.of( new SimpleGrantedAuthority("ROLE_ADMIN"), 
					new SimpleGrantedAuthority("ROLE_USER"))));	
		}else if("ataibi".equals(username)) {
			//(username,password) => ("ataibi","ataibi")
			return new User("ataibi", "$2a$10$rAEQ6oX7TCOTtG2/MIOUIOn9FqDNjTzW/hk2R2XXxbGz1TLlzcJNi",
					 new ArrayList<GrantedAuthority>(List.of(new SimpleGrantedAuthority("ROLE_DEV"))));	
		}else {
			throw new UsernameNotFoundException(username +" Introuvable");
		}	
	}
}
