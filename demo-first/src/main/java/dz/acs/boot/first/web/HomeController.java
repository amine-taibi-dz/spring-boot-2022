package dz.acs.boot.first.web;

import java.util.stream.Collectors;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	//@PreAuthorize("hasAnyRole('ROLE_READERS','ROLE_WRITERS')")
	@RequestMapping("/")
	public String hi() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String roles = SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities().stream().map(ga -> ga.getAuthority()).collect(Collectors.joining( "," ) ); 		
		return String.format(" %s Your're in web ... %s ",name,roles);
	}
	
	
	//@Secured("{ROLE_WRITERS}")
	@RequestMapping("/dark")
	public String hiDark() {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		String roles = SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities().stream().map(ga -> ga.getAuthority()).collect(Collectors.joining( "," ) ); 		
		return String.format(" %s Your're in dark-web ... %s ",name,roles);		
	}

}
