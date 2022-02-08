package dz.acs.learn.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "dz.acs.learn.service")
public class ServiceConfiguration {
//	@Bean
//	public ModulesService modulesService() {
//		return new ModulesService();
//	}
	

}
