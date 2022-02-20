package dz.acs.jwt.ressource;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgrammingResource {
	
	@Secured({ "ROLE_DEV" })
	@GetMapping("/list")
	public List<String> list(){
		return List.of("Java","Kotlin","Python","Go","Rust");
	}
	
	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/jee")
	public List<String> listJavaEE(){
		return List.of("Java","EJB","JPA","JMS","JTA");
	}
}
