package dz.acs.learn;

//import static org.assertj.core.api.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import dz.acs.learn.config.ServiceConfiguration;
import dz.acs.learn.dao.ModulesRepository;
import dz.acs.learn.model.Modules;
import dz.acs.learn.service.ModulesService;

@DataJpaTest
@ContextConfiguration(classes = ServiceConfiguration.class)
class DemoLearningServiceTests {
	@MockBean
	private ModulesRepository modulesRepository;
	
	@Autowired
	private ModulesService modulesService;
	
	private static Logger LOG =  LoggerFactory.getLogger(DemoLearningServiceTests.class); 
	
	@Test
	public void testService() {
		
		Modules modSpringBoot = new Modules();
		modSpringBoot.setId(100L);
		modSpringBoot.setName("Spring Boot");
		modSpringBoot.setNbJour(5);
		modSpringBoot.setNbSession(2);
		LOG.debug(modSpringBoot.toString());
		//chargerParId ==> repository 
		given(modulesRepository.chargerParId(100L))
			.willReturn(modSpringBoot);
		
		Modules mod = modulesService.chargerParId(100L);
		assertThat(mod,isA(Modules.class));
		assertThat(mod.getName(),is("Spring Boot"));
		assertThat(mod.getNbSession(),is(2));
		assertThat(mod.getNbJour(),is(5));
	}
}
