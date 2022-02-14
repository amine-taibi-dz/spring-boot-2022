package dz.acs.mem;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.MethodMode;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import dz.acs.mem.model.Celebrity;
import dz.acs.mem.repos.CelebrityRepository;
@DataJpaTest
@DirtiesContext(methodMode = MethodMode.BEFORE_METHOD)
public class DemoMemoireDataTests {

	@Autowired
	private CelebrityRepository celebrityRepository;
	
	@Autowired
	private TestEntityManager entityManager; 
	
	
	@Test
	public void emTest() {
		Object res = entityManager.persistAndFlush(new Celebrity("RAMA YADE", "Figurant"));
		assertThat(res,isA(Celebrity.class));
		assertThat(((Celebrity)res).getName(),equalTo("RAMA YADE"));		
	}
	
	@Test
	@BeforeTestMethod
	public void repoTest() {
		Object res = celebrityRepository.save(new Celebrity("RAMA YADE", "Figurant"));
		assertThat(res,isA(Celebrity.class));
		assertThat(((Celebrity)res).getId(),equalTo(1));
		assertThat(((Celebrity)res).getName(),equalTo("RAMA YADE"));		
	}

}
