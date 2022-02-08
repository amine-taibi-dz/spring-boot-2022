package dz.acs.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dz.acs.learn.dao.ModulesRepository;
import dz.acs.learn.model.Modules;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ModulesService {
	@Autowired
	private ModulesRepository modulesRepository;
	
	public Modules chargerParId(Long id) {
		//TODO Amine TAIBI
		return modulesRepository.chargerParId(id);
	}

	public Modules enregistrer(Modules modules) {
		return null;
	}
	

}
