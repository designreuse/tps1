package org.us.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by tilak on 3/18/2016.
 */
@XmlRootElement(name = "Outbound")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class OutBoundModel {


    private List<AvailabilityModel> availability;

    public List<AvailabilityModel> getAvailability() {
        return availability;
    }

    @XmlElement(name = "Availability")
    public void setAvailability(List<AvailabilityModel> availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "OutBound{" +
                "availability=" + availability +
                '}';
    }
}
