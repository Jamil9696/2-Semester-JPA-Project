package airportproject.repository;


import airportproject.embeddables.MaintenanceProtocolCK;
import airportproject.entities.MaintenanceProtocol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceProtocolRepo extends CrudRepository<MaintenanceProtocol, MaintenanceProtocolCK> {



}
