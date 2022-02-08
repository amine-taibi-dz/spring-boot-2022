package dz.acs.learn;



import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import dz.acs.learn.model.Modules;
@DataJpaTest()
@EnableJpaRepositories(basePackages = "dz.acs.learn.dao.sql")
@EnableMongoRepositories(basePackages = "dz.acs.learn.dao.nosql")
@DataMongoTest
@EnableAutoConfiguration
class DemoLearningDataTests {
	
	@Autowired
	private TestEntityManager em;
	
	private static Logger LOG =  LoggerFactory.getLogger(DemoLearningDataTests.class); 

	@Test
	public void dataModules() {
		Modules mod = em.persistAndFlush(new Modules(2,"Java Avancee",5));
		LOG.info(mod.getName());
	}

}
