package airportproject.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;

// Each Entity have to be accessible by JPA => provide Getters and Setters as well as default constructor
@Entity
@Setter
@Getter
@EqualsAndHashCode
@Table(name = "airport") // specify table name
public class Airport{

    @Id
    @Column(name = "IATA_Code")
    private String identifier;

    @Version
    private Integer version;

    @NotNull
    private float longitude;

    @NotNull
    private float latitude;

    @NotBlank(message = "airportName must contain a value")
    @Column(name = "airport_name")
    private String airportName;

    // multiple relationships between entities
    // should be changed in manyToMany Relationships and stored in separate tables
   @ManyToMany
    @JoinTable(
            name = "start_connection",
            joinColumns = @JoinColumn(name = "start_IATA"),
            inverseJoinColumns = @JoinColumn(name = "connection_id")
    )
    // For -ToMany Relationship
   //  use Set or Map => define EqualsAndHashCode() => lombok Annotation (I'm not sure if lombok implemented it correctly)
    private Set<FlightConnection> startConnections = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "destination_connection",
            joinColumns = @JoinColumn(name = "destination_IATA"),
            inverseJoinColumns = @JoinColumn(name = "connection_id")
    )
    private Set<FlightConnection> destinationConnections = new HashSet<>();


    public Airport() {

    }

    public Airport(String airportID, float longitude, float latitude, String airportName) {
        this.identifier = airportID;
        this.longitude = longitude;
        this.latitude = latitude;
        this.airportName = airportName;
    }

    public void addStartConnection(FlightConnection connection){
        startConnections.add(connection);
    }

    public void addDestinationConnection(FlightConnection connection){
        destinationConnections.add(connection);
    }
}
