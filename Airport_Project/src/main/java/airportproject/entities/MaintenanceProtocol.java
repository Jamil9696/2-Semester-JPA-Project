package airportproject.entities;


import airportproject.embeddables.MaintenanceProtocolCK;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;



@Entity
@Getter
@Setter
@Table(name = "Maintenance_protocol")
public class MaintenanceProtocol{

    @EmbeddedId
    @AttributeOverride(name = "registrationNumber", column =  @Column(name = "registration_number"))
    @AttributeOverride(name = "maintenanceID", column = @Column(name = "maintenance_id"))
    private MaintenanceProtocolCK maintenanceProtocolCK;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("registrationNumber")
    @JoinColumn(name = "registration_number")
    private Plane plane;

    @Version
    private Integer version;

    @Column(columnDefinition = "boolean default true")
    boolean available;

    @Column(name = "maintenance_date")
    private LocalDate date;


    public MaintenanceProtocol() {

    }

    public MaintenanceProtocol(Plane plane, boolean available, LocalDate date) {
        maintenanceProtocolCK = new MaintenanceProtocolCK();
        this.plane = plane;
        this.available = available;
        this.date = date;
    }


}
