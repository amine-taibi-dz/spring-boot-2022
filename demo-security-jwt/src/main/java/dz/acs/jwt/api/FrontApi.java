package dz.acs.jwt.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.jwt.dto.AuthenticationRequest;
import dz.acs.jwt.dto.AuthenticationResponse;
import dz.acs.jwt.service.ApiUserDetailsService;
import dz.acs.jwt.utils.JwtUtils;

@RestController
@RequestMapping("api/v1")
public class FrontApi {	
	@Autowired private AuthenticationManager authenticationManager;	
	@Autowired private JwtUtils jwtUtils;	
	@Autowired private ApiUserDetailsService apiUserDetailsService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authRequest) throws Exception{
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
			);	
		} catch (BadCredentialsException  e) {
			throw new Exception("incorrect Username or Password",e);
		}
		final UserDetails userDetails = apiUserDetailsService.loadUserByUsername(authRequest.getUsername());
		String jwtToken = jwtUtils.generateToken(userDetails);		
		return ResponseEntity.ok(new AuthenticationResponse(jwtToken));		
	}	
}
