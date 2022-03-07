package airportproject.controller;



import airportproject.entities.Plane;
import airportproject.exception.NotAddedException;
import airportproject.exception.NotFoundException;
import airportproject.exception.PlaneException;
import airportproject.message.ResponseCreator;
import airportproject.message.ResponseMsg;
import airportproject.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/plane")
public class PlaneController {

    // final = immutable = const in c++
    private final PlaneService planeService;
    private final ResponseCreator<Plane> responseCreator;

    @Autowired // service gets injected
    public PlaneController(PlaneService planeService){
        responseCreator = new ResponseCreator<>();
        this.planeService = planeService;

    }


    @GetMapping(path = "/getAll")
    public ResponseEntity<ResponseMsg<Plane>> getPlanes(HttpServletRequest request){
        try{
            return responseCreator
                    .requestSucceeded("Retrieve planes was succesful", request, planeService.getPlanes());
        }catch(Exception e){
            return responseCreator
                    .requestFailed("Request failed", request, new PlaneException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)) ;
        }
    }

    @GetMapping(path = "/getWidth={identifier}")
    public ResponseEntity<ResponseMsg<Plane>> getPlaneWidth(@PathVariable String identifier, HttpServletRequest request){

        System.out.println("identifier: " + identifier);
        try {
            // the result could be null. optional acts like a wrapper. it could contain a valid value or null
            Optional<Plane> optional = planeService.searchForPlane(identifier);
            List<Plane> list = new ArrayList<>();
            optional.ifPresent(list::add); // if optional object contains a value (functional style programming in Java)
            return responseCreator.requestSucceeded("request succeeded", request, list);

        }catch (PlaneException e){
            return responseCreator.requestFailed("request Failed", request, e);
        }
    }
    @PostMapping(path = "/add-new-plane")
    public ResponseEntity<ResponseMsg<Plane>> addPlane(@RequestBody Plane plane, HttpServletRequest request){

        try {
            planeService.addNewPlane(plane);
            String message = "plane with id= " + plane.getIdentifier() + " was successfully added";
            return responseCreator.requestSucceeded(message,request, List.of());

        }catch (NotAddedException e){
            return responseCreator.requestFailed("request Failed", request, e);
        }
    }





}
