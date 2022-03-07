package airportproject.service;


import airportproject.entities.Plane;
import airportproject.exception.NotAddedException;

import airportproject.exception.PlaneException;
import airportproject.repository.PlaneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {

    private final PlaneRepo planeRepo;

    @Autowired
    public PlaneService(PlaneRepo planeRepo){
        this.planeRepo = planeRepo;
    }


    public List<Plane> getPlanes(){
        return planeRepo.findAll();
    }

    @Transactional()
    public void addNewPlane(Plane plane) throws NotAddedException {

        if(plane.getIdentifier().length() > 10)
            throw new NotAddedException("identifier length is greater then expected", HttpStatus.BAD_REQUEST);

        if(planeRepo.findPlaneByIdentifier(plane.getIdentifier()).isPresent())
            throw new NotAddedException("Plane exists already", HttpStatus.FORBIDDEN);

        planeRepo.save(plane);


    }
    public Optional<Plane> searchForPlane(String identifier) throws PlaneException {

        if( identifier.isEmpty() || identifier.length() > 10)
            throw new PlaneException("invalid input", HttpStatus.FORBIDDEN);

        return planeRepo.findPlaneByIdentifier(identifier);

    }

}
