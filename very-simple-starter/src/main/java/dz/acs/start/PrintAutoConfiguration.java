package dz.acs.start;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PrintProperties.class)
public class PrintAutoConfiguration {
	//org.springframework.boot.autoconfigure.EnableAutoConfiguration
	// =dz.acs.start.PrintAutoConfiguration
	
	private final PrintProperties printProperties;
	
	public PrintAutoConfiguration(PrintProperties printProperties) {
		this.printProperties =printProperties;
	}
	
	@ConditionalOnMissingBean
	@Bean
	public PrintService printService() {
		return new PrintService(printProperties.getPrefix(),printProperties.getSuffix());
	}
}
