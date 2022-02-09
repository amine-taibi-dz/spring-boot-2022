package dz.acs.learn.usingstart;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dz.acs.starter.dbcount.EnableDbCounting;
import dz.acs.starter.dbcount.FacturationService;

@SpringBootApplication
@EnableDbCounting
public class DemoLearningUsingStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoLearningUsingStarterApplication.class, args);
	}
	
	@Autowired
	public FacturationService facturationService;
	
	@Bean
	public CommandLineRunner clr() {
		return (args) ->{		
			System.out.println(facturationService.facturerReduit(new BigDecimal(1_000L)));
		};
	}
}
