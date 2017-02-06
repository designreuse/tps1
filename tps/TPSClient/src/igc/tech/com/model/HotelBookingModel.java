package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HotelBookingModel {

 private String hotelBookingId, checkInDate, checkOutDate, noOfRooms, noOfAdults,
         noOfChild, finalRate, customerDetailId, roomDetailId, reserveType, cancelStatus,
         cancelDate, guestName, guestPhNo, guestEmailId, hashCode, effAdult, effChild,
         noOfGuest, rate, extraChild, extraAdult, actualRate, offerId, offerName,
         effectiveFrom, effectiveTo, offerType, offerAmount, payAtHotel, payAtHotelDate,
         paid, paidDate, payType, invoice, actualAdult, actualChild, totalGuest, totalDays,
         airportShuttle, identificationNo, arrivalDateTime, country, specialRequest, medium, childAges;
    private String roomDesc, hotelName, hotelArrival, hotelArrivalDate;

    public String getHotelBookingId() {
        return hotelBookingId;
    }

    public void setHotelBookingId(String hotelBookingId) {
        this.hotelBookingId = hotelBookingId;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(String noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public String getNoOfChild() {
        return noOfChild;
    }

    public void setNoOfChild(String noOfChild) {
        this.noOfChild = noOfChild;
    }

    public String getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(String finalRate) {
        this.finalRate = finalRate;
    }

    public String getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(String customerDetailId) {
        this.customerDetailId = customerDetailId;
    }

    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
    }

    public String getReserveType() {
        return reserveType;
    }

    public void setReserveType(String reserveType) {
        this.reserveType = reserveType;
    }

    public String getCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(String cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestPhNo() {
        return guestPhNo;
    }

    public void setGuestPhNo(String guestPhNo) {
        this.guestPhNo = guestPhNo;
    }

    public String getGuestEmailId() {
        return guestEmailId;
    }

    public void setGuestEmailId(String guestEmailId) {
        this.guestEmailId = guestEmailId;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getEffAdult() {
        return effAdult;
    }

    public void setEffAdult(String effAdult) {
        this.effAdult = effAdult;
    }

    public String getEffChild() {
        return effChild;
    }

    public void setEffChild(String effChild) {
        this.effChild = effChild;
    }

    public String getNoOfGuest() {
        return noOfGuest;
    }

    public void setNoOfGuest(String noOfGuest) {
        this.noOfGuest = noOfGuest;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getExtraChild() {
        return extraChild;
    }

    public void setExtraChild(String extraChild) {
        this.extraChild = extraChild;
    }

    public String getExtraAdult() {
        return extraAdult;
    }

    public void setExtraAdult(String extraAdult) {
        this.extraAdult = extraAdult;
    }

    public String getActualRate() {
        return actualRate;
    }

    public void setActualRate(String actualRate) {
        this.actualRate = actualRate;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(String effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public String getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(String effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public String getOfferAmount() {
        return offerAmount;
    }

    public void setOfferAmount(String offerAmount) {
        this.offerAmount = offerAmount;
    }

    public String getPayAtHotel() {
        return payAtHotel;
    }

    public void setPayAtHotel(String payAtHotel) {
        this.payAtHotel = payAtHotel;
    }

    public String getPayAtHotelDate() {
        return payAtHotelDate;
    }

    public void setPayAtHotelDate(String payAtHotelDate) {
        this.payAtHotelDate = payAtHotelDate;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getActualAdult() {
        return actualAdult;
    }

    public void setActualAdult(String actualAdult) {
        this.actualAdult = actualAdult;
    }

    public String getActualChild() {
        return actualChild;
    }

    public void setActualChild(String actualChild) {
        this.actualChild = actualChild;
    }

    public String getTotalGuest() {
        return totalGuest;
    }

    public void setTotalGuest(String totalGuest) {
        this.totalGuest = totalGuest;
    }

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    public String getAirportShuttle() {
        return airportShuttle;
    }

    public void setAirportShuttle(String airportShuttle) {
        this.airportShuttle = airportShuttle;
    }

    public String getIdentificationNo() {
        return identificationNo;
    }

    public void setIdentificationNo(String identificationNo) {
        this.identificationNo = identificationNo;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelArrival() {
        return hotelArrival;
    }

    public void setHotelArrival(String hotelArrival) {
        this.hotelArrival = hotelArrival;
    }

    public String getHotelArrivalDate() {
        return hotelArrivalDate;
    }

    public void setHotelArrivalDate(String hotelArrivalDate) {
        this.hotelArrivalDate = hotelArrivalDate;
    }

    public String getChildAges() {
        return childAges;
    }

    public void setChildAges(String childAges) {
        this.childAges = childAges;
    }

    @Override
    public String toString() {
        return "HotelBookingModel{" +
                "hotelBookingId='" + hotelBookingId + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", noOfRooms='" + noOfRooms + '\'' +
                ", noOfAdults='" + noOfAdults + '\'' +
                ", noOfChild='" + noOfChild + '\'' +
                ", finalRate='" + finalRate + '\'' +
                ", customerDetailId='" + customerDetailId + '\'' +
                ", roomDetailId='" + roomDetailId + '\'' +
                ", reserveType='" + reserveType + '\'' +
                ", cancelStatus='" + cancelStatus + '\'' +
                ", cancelDate='" + cancelDate + '\'' +
                ", guestName='" + guestName + '\'' +
                ", guestPhNo='" + guestPhNo + '\'' +
                ", guestEmailId='" + guestEmailId + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", effAdult='" + effAdult + '\'' +
                ", effChild='" + effChild + '\'' +
                ", noOfGuest='" + noOfGuest + '\'' +
                ", rate='" + rate + '\'' +
                ", extraChild='" + extraChild + '\'' +
                ", extraAdult='" + extraAdult + '\'' +
                ", actualRate='" + actualRate + '\'' +
                ", offerId='" + offerId + '\'' +
                ", offerName='" + offerName + '\'' +
                ", effectiveFrom='" + effectiveFrom + '\'' +
                ", effectiveTo='" + effectiveTo + '\'' +
                ", offerType='" + offerType + '\'' +
                ", offerAmount='" + offerAmount + '\'' +
                ", payAtHotel='" + payAtHotel + '\'' +
                ", payAtHotelDate='" + payAtHotelDate + '\'' +
                ", paid='" + paid + '\'' +
                ", paidDate='" + paidDate + '\'' +
                ", payType='" + payType + '\'' +
                ", invoce='" + invoice + '\'' +
                ", actualAdult='" + actualAdult + '\'' +
                ", actualChild='" + actualChild + '\'' +
                ", totalGuest='" + totalGuest + '\'' +
                ", totalDays='" + totalDays + '\'' +
                ", airportShuttle='" + airportShuttle + '\'' +
                ", identificationNo='" + identificationNo + '\'' +
                ", arrivalDateTime='" + arrivalDateTime + '\'' +
                ", country='" + country + '\'' +
                ", specialRequest='" + specialRequest + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}
