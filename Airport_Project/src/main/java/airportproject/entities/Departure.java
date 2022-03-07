package airportproject.entities;


import airportproject.embeddables.DepartureCK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "departure")
public class Departure  {

    @EmbeddedId // composed keys => create embeddable (preferable) or ID Class
    @AttributeOverride(name = "registrationNumber", column = @Column(name = "registration_number"))
    @AttributeOverride(name = "connectionID", column = @Column(name = "connection_id"))
    @AttributeOverride(name = "date", column = @Column(name = "departure_date"))
    private DepartureCK departureCK;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("registrationNumber") // MapsID => one attribute of the compose key is part of the relationship
    @JoinColumn(name = "registration_number", referencedColumnName = "registration_number", insertable = false, updatable = false)
    private Plane plane;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("connectionID")
    @JoinColumn(name = "connection_id", referencedColumnName = "connection_id", insertable = false, updatable = false)
    private FlightConnection flightConnection;

    @Version
    private Integer version;

    public Departure() {

    }

    public Departure(Plane plane, FlightConnection flightConnection, LocalDate date) {
        departureCK = new DepartureCK(date);
        this.plane = plane;
        this.flightConnection = flightConnection;
    }
}
