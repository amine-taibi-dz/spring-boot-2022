package dz.acs.boot.first.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true,jsr250Enabled = true)
//@EnableWebSecurity(debug = true)
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        .anyRequest().fullyAuthenticated()
	        .and()
	      .formLogin();
	  }

	  @Override
	  public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth
	      .ldapAuthentication()   
	      
	       .userDnPatterns("cn={0},ou=users,dc=acs,dc=dz")//cn={0},ou=users,dc=acs,dc=dz   
	        .groupSearchBase("ou=users,dc=acs,dc=dz")
	        //.groupSearchFilter("cn={0}")
	        //group-search-base="dc=myComp,dc=ldap"
	        //group-search-filter="uniqueMember={0}"
	        .contextSource()
	          .url("ldap://localhost:1389/")//ldap://localhost:1389/dc=acs,dc=dz
	          .root("dc=acs,dc=dz")
	          .managerDn("cn=admin,dc=acs,dc=dz")
	          .managerPassword("admin")
	          .and()
	        .passwordCompare()
	          .passwordEncoder( new LdapShaPasswordEncoder())
	          .passwordAttribute("userPassword");
	  }

	}