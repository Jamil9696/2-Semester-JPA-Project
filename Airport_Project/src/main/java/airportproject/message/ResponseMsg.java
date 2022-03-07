package airportproject.message;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
// holds the message
public class ResponseMsg <T> {

    private String url;
    private String error = "";
    private String message;

    private List<T> entityList;

    // ================= different constructors ======================
    public ResponseMsg(String message, String url, List<T> entityList){
        this.message = message;
        this.url = url;
        this.entityList = entityList;
    }

    public ResponseMsg(String message, String url, String error){
        entityList = new ArrayList<>();
        this.message = message;
        this.url = url;
        this.error = error;
    }

    public ResponseMsg(String message, String url){
       this(message, url, List.of());
    }




}
