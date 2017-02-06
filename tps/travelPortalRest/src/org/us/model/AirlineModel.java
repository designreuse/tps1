package org.us.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 3/17/2016.
 */

@XmlRootElement(name = "Airline")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class AirlineModel {


    private String airlineName;
    private String agencyName;
    private  String balanceAmount;

    public String getAirlineName() {
        return airlineName;
    }

    @XmlElement(name = "AirlineName")
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAgencyName() {
        return agencyName;
    }

    @XmlElement(name = "AgencyName")
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getBalanceAmount() {
        return balanceAmount;
    }

    @XmlElement(name = "BalanceAmount")
    public void setBalanceAmount(String balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "airlineName='" + airlineName + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", balanceAmount='" + balanceAmount + '\'' +
                '}';
    }
}
