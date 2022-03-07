package airportproject.exception;


import airportproject.interfaces.ExceptionHandling;
import org.springframework.http.HttpStatus;

import java.io.Serial;

public class PlaneException extends Exception implements ExceptionHandling{


    @Serial
    private static final long serialVersionUID = 1L;

    private final String message;
    private final HttpStatus status;

    public PlaneException(String message, HttpStatus status){
        super(message);
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() { return message; }


    public HttpStatus getStatus() { return status; }
}
