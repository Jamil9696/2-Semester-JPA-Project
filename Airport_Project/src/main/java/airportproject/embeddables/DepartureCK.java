package airportproject.embeddables;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class DepartureCK implements Serializable {


    @NotBlank(message = "registrationNumber must contain a value")
    private String registrationNumber;

    @NotNull
    private Integer connectionID;

    @NotNull
    private LocalDate date;

    public DepartureCK(){

    }
    public DepartureCK( LocalDate date){
        this.date = date;
    }
}
