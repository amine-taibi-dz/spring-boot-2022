package dz.acs.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import dz.acs.learn.dao.nosql.PersonneRepository;
import dz.acs.learn.model.Personne;

@SpringBootApplication
//@EnableMongoRepositories
//@EnableJpaRepositories
public class DemoLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoLearningApplication.class, args);
	}	
	@Autowired
	private PersonneRepository personneRepository;
	/*
	 * <mongo:mongo id="mongo" host="localhost" port="27017"/>
		<bean id="mongoTemplate" class="o.sf.data.mongodb.core.MongoTemplate">
		<constructor-arg ref="mongo"/>
		<constructor-arg name="databaseName" value="db"/>
			</bean>
	 * */


	@Bean	
	public CommandLineRunner exec() {
		return (arg) ->{
			Personne pers = new Personne(100L, "Amine TAIBI", 43);
			personneRepository.save(pers);
			
			pers = new Personne(200L, "Samir Mohammedi", 42);
			personneRepository.save(pers);
		};
	}
}
