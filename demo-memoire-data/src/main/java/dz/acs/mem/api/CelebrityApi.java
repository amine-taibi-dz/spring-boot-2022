package dz.acs.mem.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.mem.model.Celebrity;
import dz.acs.mem.repos.CelebrityRepository;
import dz.acs.mem.service.CelebrityService;
import dz.acs.mem.utils.AppException;


@RestController
@RequestMapping("/api/v1/festival")
public class CelebrityApi {
	
	
	private static Logger LOG = LoggerFactory.getLogger(CelebrityApi.class);
	
	@Autowired	
	private CelebrityService celebrityService;
	
	@Autowired	
	private CelebrityRepository celebrityRepository;
	
	@GetMapping("/list")
	public List<Celebrity> list(){	
		LOG.trace("Debut : Appel de la method list");
		List<Celebrity> res = celebrityRepository.findAll();
		try {
			res = celebrityRepository.findAll();
			LOG.debug("valeur de retour " + res);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AppException(e.getMessage(),e);
		}		
		LOG.trace("Fin : Appel de la method list");
		return res;
	}
	
	@PostMapping("/find")
	public List<Celebrity> find(@RequestBody Celebrity celeb){	
		LOG.trace("Debut : Appel de la method find");
		List<Celebrity> res = celebrityService.findByExample(celeb);		
		LOG.trace("Fin : Appel de la method find");
		return res;
	}	
}
