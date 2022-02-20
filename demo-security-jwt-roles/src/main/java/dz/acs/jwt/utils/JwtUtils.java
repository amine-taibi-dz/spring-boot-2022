package dz.acs.jwt.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {	
	private static final int EXPIRATION_DURATION = 1000*60*60*24*10;
	//@Value("${elit.jwt.secret.key:'elit-jwt-boot-feb-2022'}")
	private String SECRET_KEY="elit-jwt-boot-feb-2022";
	private final static String AUTHORITIES_KEY ="roles";

	/**
	 * 
	 * @param token
	 * @return
	 */
	private Claims extractAllClaims(String token) {

		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	/**
	 * 
	 * @param claims
	 * @param username
	 * @return
	 */
	private String createToken(Map<String, Object> claims, String username) {
		return Jwts.builder()
				.setClaims(claims)
				.setSubject(username)
				.setHeaderParam("application", "sgc")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_DURATION))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
				.compact();
	}	
	/**
	 * 
	 * @param token
	 * @return
	 */
	public String extractUserName(String token) {
		return extractClaim(token,Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token,Claims::getExpiration);
	}

	//"roles":"ROLE_USER,ROLE_ADMIN"
	private <T> T extractClaim(String token, Function<Claims,T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	//    public String getRoles() {
	//        return getString("roles");
	//    }

	/**
	 * 
	 * @param token
	 * @return
	 */
	public Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	/**
	 * generateToken
	 * @param userDetails
	 * @return
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>();
		claims.put(AUTHORITIES_KEY,
				userDetails.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(",")) );
		return createToken(claims,userDetails.getUsername());		
	}
	/**
	 * validateToken
	 * @param token
	 * @param userDetails
	 * @return
	 */
	public Boolean validateToken(String token,UserDetails userDetails) {
		final String username = extractUserName(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	/**
	 * getAuthentication
	 * @param jwtToken
	 * @param existingAuth
	 * @param userDetails
	 * @return UsernamePasswordAuthenticationToken
	 */
	public UsernamePasswordAuthenticationToken getAuthentication(
			final String jwtToken, 
			final Authentication existingAuth, 
			final UserDetails userDetails) {

		final JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET_KEY);
		
		final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(jwtToken);
		
		final Claims claims = claimsJws.getBody();
		
		final Collection<? extends GrantedAuthority> authorities =
				Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

		return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}
}
