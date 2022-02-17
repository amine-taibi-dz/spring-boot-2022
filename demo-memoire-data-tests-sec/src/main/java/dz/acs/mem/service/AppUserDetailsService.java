package dz.acs.mem.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dz.acs.mem.model.sql.AppUser;
import dz.acs.mem.repos.sql.AppUserRepository;
/**
 * AppUserDetailsService
 * @author ataibi
 *
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User connectedUser = null;
		try {
			AppUser user = appUserRepository.findByUsername(username);
			connectedUser = fillUserDetails(user);
		} catch (Exception e) {
			throw new UsernameNotFoundException(username + " introuvable !");
		}
		return connectedUser;
	}

	/**
	 * fillUserDetails from AppUser
	 * @param user
	 * @return User spring sec
	 */
	private User fillUserDetails(AppUser user) {
		List<SimpleGrantedAuthority> listRoles = Arrays.asList(user.getRoles().split(","))
				.stream()
				.map(s->new SimpleGrantedAuthority("ROLE_"+s.toUpperCase().trim()))
				.collect(Collectors.toList());
		
		User res = new User(user.getUsername(), user.getPassword(), listRoles);
		return res;
	}

}
