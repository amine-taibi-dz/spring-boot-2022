package dz.acs.resthateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class LearnApi {

	private static final String FMT_MOD = "Start, %s!";

	@RequestMapping("/start")
	public HttpEntity<Learning> start(
		@RequestParam(value = "name", defaultValue = "Hateoas") String module) {

		Learning learning = new Learning(String.format(FMT_MOD, module));
		learning.add(linkTo(methodOn(LearnApi.class).start(module)).withSelfRel());
		learning.add(linkTo(methodOn(LearnApi.class).end(module)).withRel("end"));

		return new ResponseEntity<>(learning, HttpStatus.OK);
	}
	
	@RequestMapping("/bye")
	public HttpEntity<Learning> end(
		@RequestParam(value = "name", defaultValue = "spring") String module) {

		Learning learning = new Learning(String.format(FMT_MOD, module));
		learning.add(linkTo(methodOn(LearnApi.class).end(module)).withSelfRel());

		return new ResponseEntity<>(learning, HttpStatus.OK);
	}
}
