package dz.acs.sec.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dz.acs.sec.model.Vol;

@Repository 
public interface VolRepository extends CrudRepository<Vol,Long>{

}
