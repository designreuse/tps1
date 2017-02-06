package org.us.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 3/18/2016.
 */
@XmlRootElement(name = "Flightavailability")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class FlightavailabilityModel {

    private OutBoundModel outBound;

    private InBoundModel inBound;

    public OutBoundModel getOutBound() {
        return outBound;
    }

    @XmlElement(name = "Outbound")
    public void setOutBound(OutBoundModel outBound) {
        this.outBound = outBound;
    }

    public InBoundModel getInBound() {
        return inBound;
    }

    @XmlElement(name = "Inbound")
    public void setInBound(InBoundModel inBound) {
        this.inBound = inBound;
    }

    @Override
    public String toString() {
        return "Flightavailability{" +
                "outBound=" + outBound +
                ", inBound=" + inBound +
                '}';
    }
}
