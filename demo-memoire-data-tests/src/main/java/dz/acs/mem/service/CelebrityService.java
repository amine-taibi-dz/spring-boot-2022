package dz.acs.mem.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.acs.mem.model.sql.Celebrity;
import dz.acs.mem.repos.sql.CelebrityRepository;

@Service
public class CelebrityService {
	private static Logger LOG = LoggerFactory.getLogger(CelebrityService.class);
	@Autowired	
	private CelebrityRepository celebrityRepository;
	
	public List<Celebrity> findByExample(Celebrity celeb) {
		/*List<Celebrity> res = new ArrayList<>();
		try {
			ExampleMatcher matcher = ExampleMatcher.matching()
					.withIgnorePaths("id","occupation")
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING);
			
			Example<Celebrity> celebCrit = Example.of(celeb, matcher );
			
			res = celebrityRepository.findAll(celebCrit);
			LOG.debug("valeur de retour " + res);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new AppException(e.getMessage(),e);
		}
		return res;
		*/
		return null; 
	}
	
	public List<Celebrity> findAll(){
		//return null;
		return celebrityRepository.findAll();
	}

	public Celebrity findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
