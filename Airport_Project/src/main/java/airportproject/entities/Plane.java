package airportproject.entities;


import javax.persistence.*;
import javax.validation.constraints.Min;
import airportproject.embeddables.PlaneModel;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Plane {

    @Id
    @Column(name = "registration_number")
    private String identifier;

    @Version
    private Integer version;

    @Column(name = "seat_number")
    @Min(value = 0, message = "value must be positive")
    private Integer seatNumber;

    @Embedded
    @AttributeOverride(name = "modelType", column = @Column(name = "model_type"))
    private PlaneModel planeModel;

    // bidirectional approach
    /* @OneToMany(mappedBy = "plane")
    List<MaintenanceProtocol> protocolList = new ArrayList<>();

    @OneToMany(mappedBy = "plane")
    Set<Departure> departuresList = new HashSet<>();*/


    public Plane() {

    }

    public Plane(String registrationNumber, Integer seatNumber, PlaneModel planeModel) {
        this.identifier = registrationNumber;
        this.seatNumber = seatNumber;
        this.planeModel = planeModel;
    }
}
