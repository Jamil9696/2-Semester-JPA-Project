package airportproject.embeddables;


import airportproject.enums.TravelClass;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Embeddable
@Getter
@Setter
public class BookingDetails {

    @Enumerated(EnumType.STRING)
    @NotNull
    private TravelClass travelClass;

    @NotNull
    private LocalDate date;

    public BookingDetails(){

    }

    public BookingDetails(TravelClass travelClass, LocalDate date) {
        this.travelClass = travelClass;
        this.date = date;
    }


}
