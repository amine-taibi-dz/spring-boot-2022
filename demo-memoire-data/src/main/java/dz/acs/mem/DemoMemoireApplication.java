package dz.acs.mem;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.mem.model.Celebrity;
import dz.acs.mem.model.Event;
import dz.acs.mem.repos.CelebrityRepository;
import dz.acs.mem.repos.EventRepository;

@SpringBootApplication
//@ComponentScan(basePackages = {"dz.acs.mem","dz.acs.api"})
//ajouter à cause de TestApi qui est dans dz.acs.api !! 
public class DemoMemoireApplication {

	private static Logger LOG = LoggerFactory.getLogger(DemoMemoireApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoMemoireApplication.class, args);
	}
	@RestController
	@RequestMapping("/api/v1/beans")
	static class AllBeans{
		
		@Autowired
		private ConfigurableApplicationContext appContext;
		
		@GetMapping("/")
		public String[] list(){
			return  appContext.getBeanDefinitionNames();
		}
	}
	
	@Autowired	
	private CelebrityRepository celebrityRepository;
	
	@Autowired	
	private EventRepository eventRepository;
	
	
	@Bean
	public CommandLineRunner clr1() {
		return (arg) -> {
			
			long count = eventRepository.count();
			LOG.warn( "Il y a "+count+" event(s)");
			Event event1 = new Event(100L,"Explosions nucléaires de Reggane","13 Fév.");
			
			Event event2 = new Event(200L,"Journée Mondiale de la Radio","13 Fév.");
			//eventRepository.save(event1);
			//eventRepository.save(event2);
			count = eventRepository.count();
			LOG.warn( "Il y a "+count+" event(s)");
			
			
			
			
			/*LOG.trace("FIN de L'INIT APP ==> ex.");
			LOG.debug("FIN de L'INIT APP ==> ex.");
			LOG.info( "FIN de L'INIT APP ==> ex.");
			LOG.warn( "FIN de L'INIT APP ==> ex.");
			LOG.error("FIN de L'INIT APP ==> ex.");
			long cpt = celebrityRepository.count();
			LOG.warn("Nombre de celebrity : " +cpt);
			//celebrityRepository.save(new Celebrity("Woody Allen", "Realisateur") );
			cpt = celebrityRepository.count();
			LOG.warn("Nombre de celebrity : " +cpt);
			Celebrity celeb = new Celebrity();
			celeb.setName("all");
			
			ExampleMatcher matcher = ExampleMatcher.matching()
					.withIgnorePaths("id","occupation")
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING);
			
			Example<Celebrity> celebCrit = Example.of(celeb, matcher );
			
			List<Celebrity> res = celebrityRepository.findAll(celebCrit);
			LOG.warn("Celebrity : " +res);*/
			
			
			
			
			
		};
	}
}
