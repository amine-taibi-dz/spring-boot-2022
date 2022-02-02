package dz.acs.starter.dbcount;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.CrudRepository;
/**
 * DbCountRunner
 * @author ataibi
 *
 */
public class DbCountRunner implements CommandLineRunner {
	protected final Log logger = LogFactory.getLog(getClass());
	
	private Collection<CrudRepository<?,?>> repositories;
	private String lookupPackage;
	
	public DbCountRunner(Collection<CrudRepository<?,?>> repositories,String lookupPackage) {
		this.lookupPackage=lookupPackage;
		this.repositories = repositories;
	} 
	
	@Override
	public void run(String... args) throws Exception {
		repositories.forEach(crudRepository ->
		logger.info(String.format("%s contient %s ligne(s)",getRepositoryName(crudRepository.getClass(),lookupPackage),
				crudRepository.count())));
	}
	/**
	 * getRepositoryName
	 * @param crudRepositoryClass
	 * @return  String
	 */
	private static String getRepositoryName(Class<?> crudRepositoryClass,String lookupPackage ) {
		for(Class<?> repositoryInterface :crudRepositoryClass.getInterfaces()) {
			if (repositoryInterface.getName().
					startsWith(lookupPackage)) {
				return repositoryInterface.getSimpleName();
			}
		} 
		return "Repository-Inconnu";
	}
}