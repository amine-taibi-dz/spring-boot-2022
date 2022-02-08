package dz.acs.learn.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.learn.model.Modules;
import dz.acs.learn.service.ModulesService;

@RestController
@RequestMapping("/api/v1/learn")
public class ModulesApi {
	@Autowired
	private ModulesService modulesService;
	
	@GetMapping("{idModule}")
	public Modules chargerParId(@PathVariable("idModule") Long id) {
		Modules modules = null;
		modules = modulesService.chargerParId(id);
		return modules;
		
	}
	
	@PostMapping("/add")
	public Modules enregistrer(@RequestBody Modules newModule) {
		Modules modules = null;
		modules = modulesService.enregistrer(newModule);
		return modules;
		
	}
}
