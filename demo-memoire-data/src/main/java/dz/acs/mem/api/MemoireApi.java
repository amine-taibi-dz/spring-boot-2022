package dz.acs.mem.api;

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

import dz.acs.mem.model.Event;
import dz.acs.mem.repos.EventRepository;
import dz.acs.mem.utils.AppException;


@RestController
@RequestMapping("/api/v1/mem")
public class MemoireApi {
	
	@Autowired	
	private EventRepository eventRepository;
	
//	private static final List<Event> EVENTS = new ArrayList<>(
//			List.of(new Event(100L,"Explosions nucléaires de Reggane","13 Fév."), 
//					new Event(200L,"Journée Mondiale de la Radio","13 Fév."))) ;
//	
	private static Logger LOG = LoggerFactory.getLogger(MemoireApi.class);

	
	@PostMapping("/find")
	public Iterable<Event> find(@RequestBody Event event){	
		LOG.trace("Debut : Appel de la method find");
		Iterable<Event> res = null;
		try {
			Example<Event> eventCrit = null;
			ExampleMatcher matcher =  ExampleMatcher.matching()
					.withIgnoreCase()
					.withIgnorePaths("eventId")
					.withStringMatcher(StringMatcher.CONTAINING);
			eventCrit = Example.of(event, matcher );
			res = eventRepository.findAll(eventCrit);
			LOG.debug("valeur de retour " + res);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AppException(e.getMessage(),e);
		}		
		LOG.trace("Fin : Appel de la method find");
		return res;
	}
	@GetMapping("/list")
	public Iterable<Event> list(){	
		LOG.trace("Debut : Appel de la method list");
		Iterable<Event> res = null;
		try {
			res = eventRepository.findAll();
			LOG.debug("valeur de retour " + res);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AppException(e.getMessage(),e);
		}		
		LOG.trace("Fin : Appel de la method list");
		return res;
	}
	@PostMapping("/add")
	public Iterable<Event> add(@RequestBody Event event){	
		LOG.trace("Debut : Appel de la method add");
		Iterable<Event> res = null;
		eventRepository.save(event);		
		res = eventRepository.findAll();
		LOG.debug("valeur de retour " + res);
		LOG.trace("Fin : Appel de la method add");
		return res;
	}
}
