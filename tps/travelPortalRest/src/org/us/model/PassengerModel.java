package org.us.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 3/21/2016.
 */

@XmlRootElement(name = "Passenger")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class PassengerModel {

    private  String paxType;
    private  String title;
    private  String gender;
    private  String firstName;
    private  String lastName;
    private  String nationality;
    private  String paxRemarks;

    private  String airline;
    private  String pnrNo;
    private  String paxNo;
    private  String paxId;
    private  String issueFrom;
    private  String agencyName;
    private  String issueDate;
    private  String issueBy;
    private  String flightNo;
    private  String flightDate;
    private  String departure;
    private  String flightTime;
    private  String ticketNo;
    private  String barcodeValue;
    private  String barCodeImage;
    private  String arrival;
    private  String arrivalTime;
    private  String sector;
    private  String classCode;
    private  String currency;
    private  String fare;
    private  String surcharge;
    private  String taxCurrency;
    private  String tax;
    private  String commissionPercentage;
    private  String reportingTime;
    private  String freeBaggage;


    public String getAirline() {
        return airline;
    }

    @XmlElement(name = "Airline")
    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getPnrNo() {
        return pnrNo;
    }

    @XmlElement(name = "PnrNo")
    public void setPnrNo(String pnrNo) {
        this.pnrNo = pnrNo;
    }

    public String getPaxNo() {
        return paxNo;
    }

    @XmlElement(name = "PaxNo")
    public void setPaxNo(String paxNo) {
        this.paxNo = paxNo;
    }

    public String getPaxId() {
        return paxId;
    }

    @XmlElement(name = "PaxId")
    public void setPaxId(String paxId) {
        this.paxId = paxId;
    }

    public String getIssueFrom() {
        return issueFrom;
    }

    @XmlElement(name = "IssueFrom")
    public void setIssueFrom(String issueFrom) {
        this.issueFrom = issueFrom;
    }

    public String getAgencyName() {
        return agencyName;
    }

    @XmlElement(name = "AgencyName")
    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getIssueDate() {
        return issueDate;
    }

    @XmlElement(name = "IssueDate")
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueBy() {
        return issueBy;
    }

    @XmlElement(name = "IssueBy")
    public void setIssueBy(String issueBy) {
        this.issueBy = issueBy;
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

    public String getDeparture() {
        return departure;
    }

    @XmlElement(name = "Departure")
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getFlightTime() {
        return flightTime;
    }

    @XmlElement(name = "FlightTime")
    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    @XmlElement(name = "TicketNo")
    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getBarcodeValue() {
        return barcodeValue;
    }

    @XmlElement(name = "BarCodeValue")
    public void setBarcodeValue(String barcodeValue) {
        this.barcodeValue = barcodeValue;
    }

    public String getBarCodeImage() {
        return barCodeImage;
    }

    @XmlElement(name = "BarCodeImage")
    public void setBarCodeImage(String barCodeImage) {
        this.barCodeImage = barCodeImage;
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

    public String getSector() {
        return sector;
    }

    @XmlElement(name = "Sector")
    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getClassCode() {
        return classCode;
    }

    @XmlElement(name = "ClassCode")
    public void setClassCode(String classCode) {
        this.classCode = classCode;
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

    public String getSurcharge() {
        return surcharge;
    }

    @XmlElement(name = "Surcharge")
    public void setSurcharge(String surcharge) {
        this.surcharge = surcharge;
    }

    public String getTaxCurrency() {
        return taxCurrency;
    }

    @XmlElement(name = "TaxCurrency")
    public void setTaxCurrency(String taxCurrency) {
        this.taxCurrency = taxCurrency;
    }

    public String getTax() {
        return tax;
    }

    @XmlElement(name = "Tax")
    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getCommissionPercentage() {
        return commissionPercentage;
    }

    @XmlElement(name = "CommissionPercentage")
    public void setCommissionPercentage(String commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public String getReportingTime() {
        return reportingTime;
    }

    @XmlElement(name = "ReportingTime")
    public void setReportingTime(String reportingTime) {
        this.reportingTime = reportingTime;
    }

    public String getFreeBaggage() {
        return freeBaggage;
    }

    @XmlElement(name = "FreeBaggage")
    public void setFreeBaggage(String freeBaggage) {
        this.freeBaggage = freeBaggage;
    }

    public String getPaxType() {
        return paxType;
    }

    @XmlElement(name = "PaxType")
    public void setPaxType(String paxType) {
        this.paxType = paxType;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement(name = "Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    @XmlElement(name = "Gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlElement(name = "FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlElement(name = "LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    @XmlElement(name = "Nationality")
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPaxRemarks() {
        return paxRemarks;
    }

    @XmlElement(name = "PaxRemarks")
    public void setPaxRemarks(String paxRemarks) {
        this.paxRemarks = paxRemarks;
    }

    @Override
    public String toString() {
        return "PassengerModel{" +
                "paxType='" + paxType + '\'' +
                ", title='" + title + '\'' +
                ", gender='" + gender + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", paxRemarks='" + paxRemarks + '\'' +
                ", airline='" + airline + '\'' +
                ", pnrNo='" + pnrNo + '\'' +
                ", paxNo='" + paxNo + '\'' +
                ", paxId='" + paxId + '\'' +
                ", issueFrom='" + issueFrom + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", issueBy='" + issueBy + '\'' +
                ", flightNo='" + flightNo + '\'' +
                ", flightDate='" + flightDate + '\'' +
                ", departure='" + departure + '\'' +
                ", flightTime='" + flightTime + '\'' +
                ", ticketNo='" + ticketNo + '\'' +
                ", barcodeValue='" + barcodeValue + '\'' +
                ", barCodeImage='" + barCodeImage + '\'' +
                ", arrival='" + arrival + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", sector='" + sector + '\'' +
                ", classCode='" + classCode + '\'' +
                ", currency='" + currency + '\'' +
                ", fare='" + fare + '\'' +
                ", surcharge='" + surcharge + '\'' +
                ", taxCurrency='" + taxCurrency + '\'' +
                ", tax='" + tax + '\'' +
                ", commissionPercentage='" + commissionPercentage + '\'' +
                ", reportingTime='" + reportingTime + '\'' +
                ", freeBaggage='" + freeBaggage + '\'' +
                '}';
    }
}
