package dz.acs.mem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.acs.mem.model.sql.AppUser;
import dz.acs.mem.repos.sql.AppUserRepository;
import dz.acs.start.EnablePrint;
import dz.acs.start.PrintService;
import dz.elit.fact.EnableFacturation;

@SpringBootApplication
@EnableFacturation
@EnablePrint
//@ComponentScan(basePackages = {"dz.acs.mem","dz.acs.api"})
//ajouter à cause de TestApi qui est dans dz.acs.api !! 
public class DemoMemoireApplication implements ApplicationRunner{

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
			System.out.println("Hello");
			return  appContext.getBeanDefinitionNames();
		}
	}
	
	@Autowired
	public PrintService printService;
	@Autowired
	public AppUserRepository appUserRepository;
	@Autowired
	public 
	PasswordEncoder passwordEncoder; 

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(appUserRepository.count() ==0) {			
			AppUser appUser0 = new AppUser("Amine", "TAIBI", "ataibi@gmail.com", "ataibi", passwordEncoder.encode("password")) ;
			appUser0.setRoles("USER,ADMIN");
			AppUser appUser1= new AppUser("Elit", "ELIT", "elit@gmail.com", "elit", passwordEncoder.encode("password")) ;
			appUser1.setRoles("MANAGER");
			appUserRepository.save(appUser0);
			appUserRepository.save(appUser1);	
		}
		
		
		
		printService.printText("DEMO STARTER");
		LOG.error("DEMO STARTER");
	}
}
