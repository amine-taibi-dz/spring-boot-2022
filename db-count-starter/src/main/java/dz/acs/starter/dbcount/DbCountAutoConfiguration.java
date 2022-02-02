package dz.acs.starter.dbcount;

import java.util.Collection;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;

@Configuration
@EnableConfigurationProperties(RepoProperties.class)
public class DbCountAutoConfiguration {
	
	private final RepoProperties repoProperties;

	public DbCountAutoConfiguration(RepoProperties repoProperties) {
		this.repoProperties = repoProperties;
	}	
	
	@ConditionalOnMissingBean
	@Bean
	public DbCountRunner dbCountRunner(Collection<CrudRepository<?,?>> repositories) {
		return new DbCountRunner(repositories,repoProperties.getLookupPackage());
	}
}
