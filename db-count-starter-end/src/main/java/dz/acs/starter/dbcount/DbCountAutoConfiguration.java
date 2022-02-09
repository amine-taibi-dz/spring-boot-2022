package dz.acs.starter.dbcount;

import java.util.Collection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
@EnableConfigurationProperties(value = {RepoProperties.class,FacturationProperties.class})
public class DbCountAutoConfiguration {
	
	private final RepoProperties repoProperties;
	private final FacturationProperties facturationProperties;

	public DbCountAutoConfiguration(RepoProperties repoProperties,FacturationProperties facturationProperties) {
		this.repoProperties = repoProperties;
		this.facturationProperties = facturationProperties;
	}	
	
	@ConditionalOnMissingBean
	@Bean
	public DbCountRunner dbCountRunner(Collection<CrudRepository<?,?>> repositories) {
		return new DbCountRunner(repositories,repoProperties.getLookupPackage());
	}
	
	@ConditionalOnProperty(prefix = "elit",name = "facturation.enabled",havingValue = "true" )
	@ConditionalOnMissingBean	
	@Bean
	public FacturationService facturationService() {
		return new FacturationService(facturationProperties.getTva());
	}
}
