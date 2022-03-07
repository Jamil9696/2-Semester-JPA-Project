package airportproject.message;


import airportproject.interfaces.ExceptionHandling;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// generic ResponseCreator: creates the response the controller sends back to the client
public class ResponseCreator <T> {

    // Creates a responseEntity which acts like a wrapper.
    // It contains all the information the client could be interested in
    public ResponseEntity<ResponseMsg<T>> requestSucceeded(String message, HttpServletRequest request, List<T> list){
        return new ResponseEntity<>(new ResponseMsg<T>(
                        message,
                        request.getRequestURI(),
                        list),
                HttpStatus.OK
                );
    }

    public ResponseEntity<ResponseMsg<T>> requestFailed(String message, HttpServletRequest request, ExceptionHandling e ){
        return new ResponseEntity<>(
                new ResponseMsg<>(
                        message,
                        request.getRequestURI(),
                        e.getMessage()),
                        e.getStatus()
        );
    }



}
