package dz.acs.mem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = {"dz.acs.mem","dz.acs.api"})//ajouter à cause de TestApi qui est dans dz.acs.api !! 
public class DemoMemoireApplication implements ApplicationRunner {

	private static Logger LOG = LoggerFactory.getLogger(DemoMemoireApplication.class);
	private static ConfigurableApplicationContext ctx;
	public static void main(String[] args) {
		ctx = SpringApplication.run(DemoMemoireApplication.class, args);
	}
	@RestController
	@RequestMapping("/api/v1/beans")
	static class AllBeans{
		
		@Autowired
		private ConfigurableApplicationContext appContext;
		
		@GetMapping("/")
		public String[] list(){
			return  appContext.getBeanDefinitionNames();
		}
		
	}
	
	
	@Bean
	public CommandLineRunner clr1() {
		return (arg) -> {
			LOG.trace("FIN de l'INIT APP");
			LOG.debug("FIN de l'INIT APP");
			LOG.info("FIN de l'INIT APP");
			LOG.warn("FIN de l'INIT APP");
			LOG.error("FIN de l'INIT APP");
		};
	}
	
	@Bean
	public CommandLineRunner clr2() {
		return (arg) -> {
			LOG.trace("FIN de l'INIT APP");
			LOG.debug("FIN de l'INIT APP");
			LOG.info("FIN de l'INIT APP");
			LOG.warn("FIN de l'INIT APP");
			LOG.error("FIN de l'INIT APP");
		};
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOG.trace("FIN de l'INIT APP");
		LOG.debug("FIN de l'INIT APP");
		LOG.info("FIN de l'INIT APP");
		LOG.warn("FIN de l'INIT APP");
		LOG.error("FIN de l'INIT APP");
		
	}
	

}
