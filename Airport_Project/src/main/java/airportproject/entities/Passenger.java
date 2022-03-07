package airportproject.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Passenger {

    @Id
    @SequenceGenerator(name = "Passenger_sequence",
                       sequenceName = "Passenger_sequence",
                       allocationSize = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Passenger_sequence")
    @Column(name = "client_id")
    private Integer clientID;

    @Version
    private Integer version;

    @Column(name = "client_name")
    @NotBlank(message = "name must contain a value")
    private String name;

    @Column(name = "bonusmile_account", columnDefinition = "float default 0")
    private float bonusMileAccount;

    @Column(name = "client_email")
    @Email
    @NotBlank(message = "email must contain a value")
    private String email;

    /* bidirectional approach
    @OneToMany(mappedBy = "passenger")
    Set<Booking> bookingList = new HashSet<>();*/

    public Passenger(){

    }

    public Passenger(String name, float bonusMileAccount, String email) {
        this.name = name;
        this.bonusMileAccount = bonusMileAccount;
        this.email = email;
    }
}
