package dz.acs.app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.acs.app.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	/**
	 * NamedMethode 
	 * @param userName
	 * @return AppUser
	 */
	AppUser findByUserName(String userName);
}
