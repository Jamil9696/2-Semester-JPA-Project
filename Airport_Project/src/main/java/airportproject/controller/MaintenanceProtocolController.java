package airportproject.controller;


import airportproject.entities.MaintenanceProtocol;
import airportproject.exception.PlaneException;
import airportproject.message.ResponseCreator;
import airportproject.message.ResponseMsg;
import airportproject.service.MaintenanceProtocolService;
import airportproject.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/maintenanceProtocol")
public class MaintenanceProtocolController {

    private final MaintenanceProtocolService mService;
    private final ResponseCreator<MaintenanceProtocol> responseCreator;

    @Autowired
    public MaintenanceProtocolController(MaintenanceProtocolService mService, PlaneService planeService ){
        responseCreator = new ResponseCreator<>();
        this.mService = mService;

    }

    // I didn't have time to implement the other functions and test how hibernates generates queries
    // Since we are inserting data containing a foreign key:
    // => create lock on primary key
    // => check insert is valid, maybe try to catch foreignKey Exception
    // which could be thrown by the DBSM
    // => or check manually if primary key exists (most inefficiently solution
    @PostMapping(path = "/addProtocol")
    public ResponseEntity<ResponseMsg<MaintenanceProtocol>> addProtocol(@RequestBody MaintenanceProtocol mProtocol, HttpServletRequest request){

        try {
            mService.addNewProtocol(mProtocol);
            String message = "protocol with id= " + mProtocol.getMaintenanceProtocolCK().getMaintenanceID() + " was successfully added";
            return responseCreator.requestSucceeded(message,request, List.of());

        }catch (PlaneException e){
            return responseCreator.requestFailed("request Failed",request, e);
        }


    }

}
