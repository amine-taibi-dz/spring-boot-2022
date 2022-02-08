package dz.acs.learn.dao.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.acs.learn.model.Modules;

@Repository
public interface ModulesRepository extends JpaRepository<Modules,Long>{

}
