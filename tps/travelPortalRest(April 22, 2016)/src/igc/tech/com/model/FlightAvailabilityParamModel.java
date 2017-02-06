package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ganga on 3/27/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class FlightAvailabilityParamModel {
    private String userId;
    private String password;
    private String agencyId;
    private String sectorFrom;
    private String sectorTo;
    private String flightDate;
    private String tripType;
    private String returnDate;
    private String nationality;
    private String adult;
    private String child;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getSectorFrom() {
        return sectorFrom;
    }

    public void setSectorFrom(String sectorFrom) {
        this.sectorFrom = sectorFrom;
    }

    public String getSectorTo() {
        return sectorTo;
    }

    public void setSectorTo(String sectorTo) {
        this.sectorTo = sectorTo;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getTripType() {
        return tripType;
    }

    public void setTripType(String tripType) {
        this.tripType = tripType;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "FlightAvailabilityParamModel{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", agencyId='" + agencyId + '\'' +
                ", sectorFrom='" + sectorFrom + '\'' +
                ", sectorTo='" + sectorTo + '\'' +
                ", flightDate='" + flightDate + '\'' +
                ", tripType='" + tripType + '\'' +
                ", returnDate='" + returnDate + '\'' +
                ", nationality='" + nationality + '\'' +
                ", adult='" + adult + '\'' +
                ", child='" + child + '\'' +
                '}';
    }
}
