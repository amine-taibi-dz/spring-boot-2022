package dz.acs.app.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dev")
public class ProgrammingApi {
	@GetMapping("/list")
	public List<String> list(){
		return List.of("JAVA","PYTHON","GO");
	}

}
