package dz.acs.jwt.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import dz.acs.jwt.service.ApiUserDetailsService;
import dz.acs.jwt.utils.JwtUtils;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	private  final String PREFIX= "Bearer "; 
	private  final String AUTORIZATION = "Authorization";	
	@Autowired
	private JwtUtils jwtUtils;	
	@Autowired
	private ApiUserDetailsService apiUserDetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		String auth = request.getHeader(AUTORIZATION);
		if(auth != null && auth.startsWith(PREFIX)) {
			String jwt = auth.substring(PREFIX.length());
			String userName = jwtUtils.extractUserName(jwt);
			
			if(userName!=null && SecurityContextHolder.getContext().getAuthentication() ==null) {
				UserDetails userDetails = this.apiUserDetailsService.loadUserByUsername(userName);
				if(jwtUtils.validateToken(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken authentication = null;
					
					authentication = jwtUtils.getAuthentication(jwt, 
							SecurityContextHolder.getContext().getAuthentication(), userDetails);
					authentication.setDetails(
							new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}				
			}			
		}
		chain.doFilter(request, response);
	}
}
