package dz.acs.learn.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.learn.dao.sql.ModulesRepository;
import dz.acs.learn.model.Modules;

@RestController
@RequestMapping("/api/v1/learn")
public class ModuleApi {
	@Autowired
	private ModulesRepository modulesRepository;
	private static final Logger LOGGER =  LoggerFactory.getLogger(ModuleApi.class);		
	@GetMapping("/list")
	public List<Modules> list(){
		List<Modules> modules = modulesRepository.findAll();
		LOGGER.error("ERROR: HELLO list modules");
		LOGGER.trace("TRACE : HELLO list modules");
		
		return modules;		
	}
	
	@PostMapping("/add")
	public void put(@RequestBody Modules addModule){
		modulesRepository.save(addModule);
		//MODULES.add(addModule);		
	}
	
	@PostMapping("/search")
	public List<Modules> search(@RequestBody Modules exampleModule){
		
		Example<Modules> example = createExample(exampleModule);
		return modulesRepository.findAll(example);
		//MODULES.add(addModule);		
	}

	/**
	 * 
	 * @param exampleModule
	 * @return
	 */
	private Example<Modules> createExample(Modules exampleModule) {
		ExampleMatcher exampleMatcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withIgnorePaths("id", "nbSession")
				.withStringMatcher(StringMatcher.CONTAINING);
		Example<Modules> example = Example.of(exampleModule, exampleMatcher);
		return example;
	}
}
/* private static final List<Modules> MODULES = new ArrayList<Modules>(
	List.of(new Modules("Java Initiation 01",5),
	   		new Modules("Spring Core",4), 
	        new Modules("Spring Web et Data",5),
			new Modules("Spring Integration Entreprise",4), 
			new Modules("Spring Boot et Rest",5)));	
 * **/
 