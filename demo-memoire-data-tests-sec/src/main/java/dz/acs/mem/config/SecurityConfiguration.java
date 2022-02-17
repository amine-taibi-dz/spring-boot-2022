package dz.acs.mem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,jsr250Enabled = true,securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsService appUserDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder enc=new BCryptPasswordEncoder();		
		return enc;
		//System.out.println( enc.encode("password"));
		//return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		  .authorizeRequests()
		    .mvcMatchers("/api/v1/fact/**").hasAnyRole("FACT")
		  	.mvcMatchers("/api/v1/festival/**").hasAnyRole("ADMIN","CINE")
		    .mvcMatchers("/api/v1/**").hasRole("ADMIN")			
			.anyRequest().authenticated()
			
		.and().formLogin()
		
		.and().httpBasic(); 

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService);		
	}

}
