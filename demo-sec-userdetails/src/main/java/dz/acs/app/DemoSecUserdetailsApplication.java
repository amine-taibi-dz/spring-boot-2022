package dz.acs.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import dz.acs.app.model.AppUser;
import dz.acs.app.repos.AppUserRepository;

@SpringBootApplication
public class DemoSecUserdetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSecUserdetailsApplication.class, args);
	}
	
	
	@Autowired
	private AppUserRepository appUserRepository; 
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public CommandLineRunner initUsers() {		
		return (args) ->{
			if(appUserRepository.count()==0) {
				AppUser user = new AppUser("Amine TAIBI", "ataibi", passwordEncoder.encode("password"));				
				appUserRepository.save(user);	
			}
		};
	}
	

}
