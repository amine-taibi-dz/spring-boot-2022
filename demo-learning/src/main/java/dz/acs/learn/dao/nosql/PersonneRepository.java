package dz.acs.learn.dao.nosql;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import dz.acs.learn.model.Personne;

@Repository
public interface PersonneRepository extends MongoRepository<Personne,String>{
	@Query("{'name' : ?0}")
	public Iterable<Personne> searchByName(String personName);

}
