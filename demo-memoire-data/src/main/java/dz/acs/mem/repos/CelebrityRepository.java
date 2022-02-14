package dz.acs.mem.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.acs.mem.model.Celebrity;

@Repository
public interface CelebrityRepository extends JpaRepository<Celebrity, Integer> {

}
