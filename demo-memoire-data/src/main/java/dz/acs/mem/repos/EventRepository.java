package dz.acs.mem.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import dz.acs.mem.model.Event;
@Repository
public interface EventRepository extends CrudRepository<Event, Long> ,
				QueryByExampleExecutor<Event>{
}
