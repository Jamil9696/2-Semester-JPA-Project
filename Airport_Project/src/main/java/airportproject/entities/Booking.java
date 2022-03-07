package airportproject.entities;

import airportproject.embeddables.BookingDetails;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "booking", schema = "public") // schema definition (not needed here)
public class Booking{

    // postgres and oracle generate auto values by using a sequence Generator
    // if possible, always use GenerationType.SEQUENCE instead of GenerationType.Identity
    @Id
    @SequenceGenerator(name = "booking_sequence",
                       sequenceName = "booking_sequence",
                       allocationSize = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_sequence")
    @Column(name = "booking_id")
    private Integer bookingID;

    @NotNull
    private float price;

    @Embedded // for embeddable: use @AttributeOverride for assigning attributes to database columns
    @AttributeOverride(name = "travelClass", column = @Column(name = "seat_area"))
    @AttributeOverride(name = "date", column = @Column(name = "booking_date"))
    private BookingDetails bookingDetails;

    @Version
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY) // all toOne Relationships are using FetchType.EAGER by default
    @JoinColumn(name = "client_id")
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "connection_id")
    private FlightConnection flightConnection;

    public Booking(){

    }

    public Booking( float price, BookingDetails bookingDetails, Passenger passenger) {

        this.price = price;
        this.bookingDetails = bookingDetails;
        this.passenger = passenger;
        //this.flightConnection = flightConnection;
    }
}
