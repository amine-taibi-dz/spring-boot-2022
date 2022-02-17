package dz.acs.mem.repos.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.acs.mem.model.sql.AppUser;
/**
 * AppUserRepository pour authentication
 * @author ataibi
 *
 */
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	/**
	 * findByUserName utilisé par le service userDetailsService 
	 * @param username
	 * @return AppUser
	 */
	public AppUser findByUsername(String username);
}
