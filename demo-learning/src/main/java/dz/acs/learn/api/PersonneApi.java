package dz.acs.learn.api;

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

import dz.acs.learn.dao.nosql.PersonneRepository;
import dz.acs.learn.model.Modules;
import dz.acs.learn.model.Personne;

@RestController
@RequestMapping("/api/v1/rh/")
public class PersonneApi {
	@Autowired
	private PersonneRepository personneRepository;
	private static final Logger LOGGER =  LoggerFactory.getLogger(PersonneApi.class);
		
	@GetMapping("/list")
	public List<Personne> list(){
		//{"name" :{#eq:"?1"}}
		//Select p from Personne where p.name = ?1	
		List<Personne> personnes = personneRepository.findAll();
		LOGGER.error("ERROR : HELLO list personne");
		LOGGER.trace("TRACE : HELLO list personne");
		return personnes;		
	}
	
	
	@PostMapping("/search")
	public List<Personne> search(@RequestBody Personne examplePersonne){
		Example<Personne> example = createExample(examplePersonne);
		return personneRepository.findAll(example);		
	}

	/**
	 * createExample
	 * @param examplePersonne
	 * @return Example<Personne>
	 */
	private Example<Personne> createExample(Personne examplePersonne) {
		ExampleMatcher exampleMatcher = ExampleMatcher
				.matching()
				.withIgnoreCase()
				.withIgnorePaths("personId", "age")
				.withStringMatcher(StringMatcher.CONTAINING);
		Example<Personne> example = Example.of(examplePersonne, exampleMatcher);
		return example;
	}
	
	
}