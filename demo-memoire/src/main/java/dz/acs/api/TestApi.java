package dz.acs.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestApi {
	
	@RequestMapping("/")
	public String test() {
		return "hi";
	}
}
