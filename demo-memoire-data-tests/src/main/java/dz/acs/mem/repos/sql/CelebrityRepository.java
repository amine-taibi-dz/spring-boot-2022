package dz.acs.mem.repos.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.acs.mem.model.sql.Celebrity;

@Repository
public interface CelebrityRepository extends JpaRepository<Celebrity, Integer> {

}
