package dz.acs.learn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dz.acs.learn.model.Modules;

@Repository
public interface ModulesRepository extends JpaRepository<Modules,Long>{

	@Query("SELECT m FROM Modules m where m.id = ?1")
	public Modules chargerParId(long id);
}
