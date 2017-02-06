package igc.tech.com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 3/21/2016.
 */

@XmlRootElement(name = "TicketDetail")
public class TicketDetailModel {


    private  String pnrNo;
    private  String airline;
    private  String issueDate;
    private  String flightNo;
    private  String flightDate;
    private  String sectorPair;
    private  String classCode;
    private  String ticketNo;
    private  String passengerName;
    private  String nationality;
    private  String paxType;
    private  String currency;
    private  String fare;
    private  String fsc;
    private  String tax;

    public String getPnrNo() {
        return pnrNo;
    }

    @XmlElement(name = "PnrNo")
    public void setPnrNo(String pnrNo) {
        this.pnrNo = pnrNo;
    }

    public String getAirline() {
        return airline;
    }

    @XmlElement(name = "Airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getIssueDate() {
        return issueDate;
    }

    @XmlElement(name = "IssueDate")
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getFlightNo() {
        return flightNo;
    }

    @XmlElement(name = "FlightNo")
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getFlightDate() {
        return flightDate;
    }

    @XmlElement(name = "FlightDate")
    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getSectorPair() {
        return sectorPair;
    }

    @XmlElement(name = "SectorPair")
    public void setSectorPair(String sectorPair) {
        this.sectorPair = sectorPair;
    }

    public String getClassCode() {
        return classCode;
    }

    @XmlElement(name = "ClassCode")
    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    @XmlElement(name = "TicketNo")
    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getPassengerName() {
        return passengerName;
    }

    @XmlElement(name = "PassengerName")
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getNationality() {
        return nationality;
    }

    @XmlElement(name = "Nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPaxType() {
        return paxType;
    }

    @XmlElement(name = "PaxType")
    public void setPaxType(String paxType) {
        this.paxType = paxType;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlElement(name = "Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFare() {
        return fare;
    }

    @XmlElement(name = "Fare")
    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getFsc() {
        return fsc;
    }

    @XmlElement(name = "FSC")
    public void setFsc(String fsc) {
        this.fsc = fsc;
    }

    public String getTax() {
        return tax;
    }

    @XmlElement(name = "TAX")
    public void setTax(String tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "TicketDetailModel{" +
                "pnrNo='" + pnrNo + '\'' +
                ", airline='" + airline + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", flightDate='" + flightDate + '\'' +
                ", sectorPair='" + sectorPair + '\'' +
                ", classCode='" + classCode + '\'' +
                ", ticketNo='" + ticketNo + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", paxType='" + paxType + '\'' +
                ", currency='" + currency + '\'' +
                ", fare='" + fare + '\'' +
                ", fsc='" + fsc + '\'' +
                ", tax='" + tax + '\'' +
                '}';
    }
}
