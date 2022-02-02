package dz.acs.sec.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.sec.model.Vol;

@RestController
@RequestMapping("vols")
public class VolsController {
	@GetMapping("/list")
	public List<Vol> list(){
		Vol v1 = Vol.builder()
					.id(10L)
					.code("AH2010")
					.compagnie("Air Algerie")
					.heureDepart("10:05")
					.maxNbPassengers(150L)
					.build();
		List<Vol> vols = List.of(v1);
		return vols ;
	}
}
