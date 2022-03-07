package airportproject.repository;

import airportproject.entities.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaneRepo extends JpaRepository<Plane, String> {

    Optional<Plane> findPlaneByIdentifier(String registrationNumber);

    List<Plane> findAll();







}
