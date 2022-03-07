package airportproject.interfaces;

import org.springframework.http.HttpStatus;


// all interfaces implements this interface. We are accessing all different exceptions
// through the ExceptionHandling interface
public interface ExceptionHandling {

     String getMessage();
     HttpStatus getStatus();
}
