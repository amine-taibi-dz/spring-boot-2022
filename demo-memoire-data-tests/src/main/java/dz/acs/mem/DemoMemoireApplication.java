package dz.acs.mem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan(basePackages = {"dz.acs.mem","dz.acs.api"})
//ajouter à cause de TestApi qui est dans dz.acs.api !! 
public class DemoMemoireApplication {

	private static Logger LOG = LoggerFactory.getLogger(DemoMemoireApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoMemoireApplication.class, args);
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
	
	
	
	
}
