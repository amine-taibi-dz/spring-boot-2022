package dz.acs.learn;

//import static org.assertj.core.api.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dz.acs.learn.dao.ModulesRepository;
import dz.acs.learn.model.Modules;

@DataJpaTest
class DemoLearningDataTests {
	
	@Autowired
	private TestEntityManager em;
	@Autowired	
	private ModulesRepository modulesRepository;
	private static Logger LOG =  LoggerFactory.getLogger(DemoLearningDataTests.class); 

	@Test
	public void EmSave() {
		Modules mod = em.persistAndFlush(new Modules(2,"Java Avancee",5));		
		LOG.info("######"+mod.getName()+"######");
	}
	
	@Test
	public void repoSave() {		
		long cnt = modulesRepository.count();
		Modules mod = modulesRepository.save(new Modules(2,"Java Avancee",5));
		long cnt1 = modulesRepository.count();
		//cnt1 == cnt+1
		assertThat(cnt1,equalTo(cnt+1));
		assertThat(mod.getName(),is("Java Avancee"));
		assertThat(mod.getNbSession(),is(2));
		assertThat(mod.getNbJour(),is(5));		
	}
	
	@Test
	public void repoCharger() {		
		long cnt = modulesRepository.count();
		Modules mod = modulesRepository.save(new Modules(2,"Java Avancee",5));
		long cnt1 = modulesRepository.count();
		//cnt1 == cnt+1
		assertThat(cnt1,equalTo(cnt+1));
		assertThat(mod.getName(),is("Java Avancee"));
		assertThat(mod.getNbSession(),is(2));
		assertThat(mod.getNbJour(),is(5));	
		Modules modulesId = modulesRepository.chargerParId(mod.getId());
		assertThat(modulesId.getName(),is("Java Avancee"));		
	}
	
	@Test
	public void repoDelete() {		
		long cnt = modulesRepository.count();
		Modules mod = modulesRepository.save(new Modules(2,"Java Avancee",5));
		long cnt1 = modulesRepository.count();
		assertThat(cnt1,equalTo(cnt+1));
		assertThat(mod.getName(),is("Java Avancee"));
		assertThat(mod.getNbSession(),is(2));
		assertThat(mod.getNbJour(),is(5));//		
		modulesRepository.delete(mod);
		long cnt2 = modulesRepository.count();		
		assertThat(cnt2,equalTo(cnt1-1));		
		assertThat(modulesRepository.existsById(mod.getId()),equalTo(false));
	}
}
