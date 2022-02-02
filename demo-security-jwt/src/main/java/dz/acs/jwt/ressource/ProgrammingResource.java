package dz.acs.jwt.ressource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProgrammingResource {
	
	@GetMapping("/list")
	public List<String> list(){
		return List.of("Java","Kotlin","Python","Go","Rust");
	}
}
