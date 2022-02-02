package dz.acs.jwt.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class ApiUserDetailsService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) 
			 throws UsernameNotFoundException {
		return new User("elit", "elit",List.of(
				new SimpleGrantedAuthority("ADMIN_ROLE"), 
				new SimpleGrantedAuthority("USER_ROLE")));
	}
}
