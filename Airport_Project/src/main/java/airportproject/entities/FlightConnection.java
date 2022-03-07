package airportproject.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Setter
@Getter
@Table(name = "flight_connection")
public class FlightConnection  {

    @Id
    @SequenceGenerator(name = "flight_connection_sequence",
                       sequenceName = "flight_connection_sequence",
                       allocationSize = 5)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_connection_sequence")
    @Column(name = "connection_id")
    private Integer connectionID;

    @Version
    private Integer version;

    @Column(name = "flight_connection_name")
    @NotBlank(message = "connectionName must contain a value")
    private String connectionName;

    @ManyToMany(mappedBy = "startConnections")
    private Set<Airport> startAirports = new HashSet<>();

    @ManyToMany(mappedBy = "destinationConnections")
    private Set<Airport> destinationAirports = new HashSet<>();


    /* bidirectional approach => causes multiple query => FlightConnection doesn't know anything about booking and departure
    @OneToMany(mappedBy = "flightConnection")
    private Set<Departure> departures = new HashSet<>();

    @OneToMany(mappedBy = "flightConnection")
    Set<Booking> bookingList = new HashSet<>();*/


    public FlightConnection() {

    }

    public FlightConnection( String connectionName) {
        this.connectionName = connectionName;
    }

    public void addStartAirport(Airport airport){
        startAirports.add(airport);
    }

    public void addDestinationAirport(Airport airport){
        destinationAirports.add(airport);
    }
}
