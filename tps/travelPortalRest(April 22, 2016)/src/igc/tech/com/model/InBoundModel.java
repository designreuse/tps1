package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by tilak on 3/18/2016.
 */
@XmlRootElement(name = "Inbound")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class InBoundModel {


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
        return "InBound{" +
                "availability=" + availability +
                '}';
    }
}
