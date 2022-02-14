package dz.acs.mem.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.mem.model.Event;
import dz.acs.mem.utils.AppException;


@RestController
@RequestMapping("/api/v1/mem")
public class MemoireApi {
	private static final List<Event> EVENTS = new ArrayList<>(
			List.of(new Event("Explosions nucléaires de Reggane","13 Fév."), 
					new Event("Journée Mondiale de la Radio","13 Fév."))) ;
	
	private static Logger LOG = LoggerFactory.getLogger(MemoireApi.class);

	@GetMapping("/list")
	public List<Event> list(){	
		LOG.trace("Debut : Appel de la method list");
		List<Event> res = null;
		try {
			res = EVENTS;
			LOG.debug("valeur de retour " + res);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AppException(e.getMessage(),e);
		}		
		LOG.trace("Fin : Appel de la method list");
		return res;
	}
	@PostMapping("/add")
	public List<Event> add(@RequestBody Event event){	
		LOG.trace("Debut : Appel de la method add");
		List<Event> res = null;
		EVENTS.add(event);
		res = EVENTS;
		LOG.debug("valeur de retour " + res);
		LOG.trace("Fin : Appel de la method add");
		return res;
	}
}
