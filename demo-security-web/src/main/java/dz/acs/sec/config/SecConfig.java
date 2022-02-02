package dz.acs.sec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecConfig  extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests()
	            .mvcMatchers("/vols/**").hasRole("ADMIN")
	            .anyRequest().authenticated()
	            .and()
	            .formLogin()
	            .and()
	            .httpBasic();
	}
	
	
	private final PasswordEncoder pwEncoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();
	@Bean
	UserDetailsService authentication() {
		UserDetails ataibi = User.builder()
				.username("ataibi")
				.password(pwEncoder.encode("pswd"))
				.roles("USER")
				.build();
		UserDetails elit = User.builder()
				.username("elit")
				.password(pwEncoder.encode("pswd"))
				.roles("USER", "ADMIN")
				.build();		
		return new InMemoryUserDetailsManager(ataibi, elit);
	}
	
}
