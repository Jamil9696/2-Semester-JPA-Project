package airportproject.embeddables;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;


@Embeddable
@Getter
@Setter
public class PlaneModel {

    @NotBlank(message = "modelType must contain a value")
    private String modelType;

    public PlaneModel() {
    }
}
