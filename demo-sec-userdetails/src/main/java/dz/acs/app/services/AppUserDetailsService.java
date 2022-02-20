package dz.acs.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dz.acs.app.model.AppUser;
import dz.acs.app.repos.AppUserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private AppUserRepository appUserRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			AppUser appUser  = appUserRepository.findByUserName(username);
			user = fillUserWith(appUser);
		} catch (Exception e) {
			throw new UsernameNotFoundException("probleme dd'authentification");
		}
		return user;
	}

	/**
	 * fillUserWith
	 * @param appUser
	 * @return User spring
	 */
	private User fillUserWith(AppUser appUser) {
		User user = new User(appUser.getUserName(), appUser.getPassword(),List.of());
		return user;
	}

}
