package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ganga on 3/28/2016.
 */
@XmlRootElement(name = "FlightDetail")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class FlightDetailModel {
    private String airline;
    private String airlineLogo;
    private String flightDate;
    private String flightNo;
    private String departure;
    private String departureTime;
    private String arrival;
    private String arrivalTime;
    private String aircraftType;
    private String adult;
    private String child;
    private String infant;
    private String flightId;
    private String flightClassCode;
    private String currency;
    private String adultFare;
    private String childFare;
    private String infantFare;
    private String resFare;
    private String fuelSurcharge;
    private String tax;
    private String refundable;
    private String freeBaggage;
    private String agencyCommission;
    private String childCommission;
    private String callingStationId;
    private String callingStation;

    public String getAirline() {
        return airline;
    }

    @XmlElement(name = "Airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAirlineLogo() {
        return airlineLogo;
    }

    @XmlElement(name = "AirlineLogo")
    public void setAirlineLogo(String airlineLogo) {
        this.airlineLogo = airlineLogo;
    }

    public String getFlightDate() {
        return flightDate;
    }

    @XmlElement(name = "FlightDate")
    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFlightNo() {
        return flightNo;
    }

    @XmlElement(name = "FlightNo")
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getDeparture() {
        return departure;
    }

    @XmlElement(name = "Departure")
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @XmlElement(name = "DepartureTime")
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrival() {
        return arrival;
    }

    @XmlElement(name = "Arrival")
    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    @XmlElement(name = "ArrivalTime")
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    @XmlElement(name = "AircraftType")
    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public String getAdult() {
        return adult;
    }

    @XmlElement(name = "Adult")
    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getChild() {
        return child;
    }

    @XmlElement(name = "Child")
    public void setChild(String child) {
        this.child = child;
    }

    public String getInfant() {
        return infant;
    }

    @XmlElement(name = "Infant")
    public void setInfant(String infant) {
        this.infant = infant;
    }

    public String getFlightId() {
        return flightId;
    }

    @XmlElement(name = "FlightId")
    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightClassCode() {
        return flightClassCode;
    }


    @XmlElement(name = "FlightClassCode")
    public void setFlightClassCode(String flightClassCode) {
        this.flightClassCode = flightClassCode;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlElement(name = "Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAdultFare() {
        return adultFare;
    }

    @XmlElement(name = "AdultFare")
    public void setAdultFare(String adultFare) {
        this.adultFare = adultFare;
    }

    public String getChildFare() {
        return childFare;
    }

    @XmlElement(name = "ChildFare")
    public void setChildFare(String childFare) {
        this.childFare = childFare;
    }

    public String getInfantFare() {
        return infantFare;
    }

    @XmlElement(name = "InfantFare")
    public void setInfantFare(String infantFare) {
        this.infantFare = infantFare;
    }

    public String getResFare() {
        return resFare;
    }

    @XmlElement(name = "ResFare")
    public void setResFare(String resFare) {
        this.resFare = resFare;
    }

    public String getFuelSurcharge() {
        return fuelSurcharge;
    }


    @XmlElement(name = "FuelSurcharge")
    public void setFuelSurcharge(String fuelSurcharge) {
        this.fuelSurcharge = fuelSurcharge;
    }

    public String getTax() {
        return tax;
    }

    @XmlElement(name = "Tax")
    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getRefundable() {
        return refundable;
    }

    @XmlElement(name = "Refundable")
    public void setRefundable(String refundable) {
        this.refundable = refundable;
    }

    public String getFreeBaggage() {
        return freeBaggage;
    }

    @XmlElement(name = "FreeBaggage")
    public void setFreeBaggage(String freeBaggage) {
        this.freeBaggage = freeBaggage;
    }

    public String getAgencyCommission() {
        return agencyCommission;
    }

    @XmlElement(name = "AgencyCommission")
    public void setAgencyCommission(String agencyCommission) {
        this.agencyCommission = agencyCommission;
    }

    public String getChildCommission() {
        return childCommission;
    }

    @XmlElement(name = "ChildCommission")
    public void setChildCommission(String childCommission) {
        this.childCommission = childCommission;
    }

    public String getCallingStationId() {
        return callingStationId;
    }

    @XmlElement(name = "CallingStationId")
    public void setCallingStationId(String callingStationId) {
        this.callingStationId = callingStationId;
    }

    public String getCallingStation() {
        return callingStation;
    }

    @XmlElement(name = "CallingStation")
    public void setCallingStation(String callingStation) {
        this.callingStation = callingStation;
    }
}
