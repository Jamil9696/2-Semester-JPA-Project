package airportproject.service;


import airportproject.entities.MaintenanceProtocol;
import airportproject.exception.PlaneException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class MaintenanceProtocolService {


    public void addNewProtocol(MaintenanceProtocol mProtocol) throws PlaneException {

       throw new PlaneException("", HttpStatus.BAD_REQUEST);
    }
}
