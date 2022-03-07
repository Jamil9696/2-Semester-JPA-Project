package airportproject.embeddables;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class MaintenanceProtocolCK implements Serializable {

    @NotBlank(message = "registrationNumber must contain a value")
    private String registrationNumber;

    @SequenceGenerator(name = "maintenance_sequence",
                       sequenceName = "maintenance_sequence",
                       allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "maintenance_sequence")
    private Integer maintenanceID;

    public MaintenanceProtocolCK(){

    }
}
