package dz.acs.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import dz.acs.jwt.filters.JwtRequestFilter;
import dz.acs.jwt.service.ApiUserDetailsService;
@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity(
		jsr250Enabled = false,
		prePostEnabled = false,
		securedEnabled = true)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Autowired private ApiUserDetailsService apiUserDetailsService;
	
	@Autowired private JwtRequestFilter jwtRequestFilter;
	@Autowired private AuthEntryPointJwt unauthorizedHandler;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(apiUserDetailsService).passwordEncoder(passwordEncoder());
	}	

	@Bean @Override	
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.authorizeRequests()
			.antMatchers("/api/v1/authenticate").permitAll()
			.antMatchers("/api/v1/validate").permitAll()
			.antMatchers("/api/v1/revoke").permitAll()
			
			.anyRequest().authenticated()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		//NoOpPasswordEncoder.getInstance();
	}
}
