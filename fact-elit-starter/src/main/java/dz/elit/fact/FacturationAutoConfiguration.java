package dz.elit.fact;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {TvaProperties.class})
public class FacturationAutoConfiguration {
	private final TvaProperties tvaProperties;
	// declarer les beans 
	
	@Bean
	@ConditionalOnMissingBean
	public FacturationService facturationService() {
		return new FacturationService(tvaProperties.getTaux(), tvaProperties.getTauxReduit());  
	}
	
	public FacturationAutoConfiguration(TvaProperties tvaProperties) {
		super();
		this.tvaProperties = tvaProperties;
	}

	public TvaProperties getTvaProperties() {
		return tvaProperties;
	}
}
