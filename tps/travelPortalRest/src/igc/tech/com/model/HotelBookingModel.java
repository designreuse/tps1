package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelBookingModel extends  ResponseModel {

    private String roomDetailId;
    private String checkInDate;
    private String checkOutDate;
    private String noOfRooms;
    private String noOfAdult;
    private String noOfChild;
    private String childAges;
    private String hashCode;
    private String customerDetailId;
    private String guestName;
    private String guestPhNo;
    private  String guestEmailId;
    private  String hotelBookingId;
    private  String configId;
    private  String invoice;
    private  String payType;
    private  String finalRate;
    private  String searchValue;
    private  String payAtHotel;
    private  String roomTypeDesc;
    private  String hotelName;
    private  String hotelAddress;
    private  String totalBooked;

     /////////////////

    private String reserveType;
    private String cancelStatus;
    private String  cancelDate;
    private String effAdult;
    private String effChild;
    private String noOfGuest;
    private String rate;
    private String extraChild;
    private String extraAdult;
    private String actualRate;
    private String offerId;
    private String offerName;
    private String offerType;
    private String offerAmount;
    private String paid;
    private String actualAdult;
    private String actualChild;
    private String totalGuest;
    private String totalDays;

    //////////////////////

    private List<PayGateAccessModel> payGateAccessList;
    private List<HotelBookingModel> hotelBookingList;
    private String paymentStatus;
    private String perRate;

    private String hotelPhNo1;
    private String hotelPhNo2;
    private String hotelPhNo3;
    private String addressId;
    private String airportShuttle;
    private String identificationNo;
    private String arrivalDateTime;
    private String country;
    private String roomImageUrl;
    private String hotelImageUrl;
    private String checkInTo;
    private String checkOutTo;
    private String specialRequest;
    private String medium;
    private String hotelDetailId;
    private String payAtHotelDate;
    private String paidDate;
    private String cancelFlag;
    private String payOptionFlag;
    private String currencyDesc;

    private  HotelDetailModel hotelDetail;

    public String getCurrencyDesc() {
        return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }

    public String getPayOptionFlag() {
        return payOptionFlag;
    }

    public void setPayOptionFlag(String payOptionFlag) {
        this.payOptionFlag = payOptionFlag;
    }

    public String getCancelFlag() {
        return cancelFlag;
    }

    public void setCancelFlag(String cancelFlag) {
        this.cancelFlag = cancelFlag;
    }

    public String getTotalBooked() {
        return totalBooked;
    }

    public void setTotalBooked(String totalBooked) {
        this.totalBooked = totalBooked;
    }

    public String getPayAtHotelDate() {
        return payAtHotelDate;
    }

    public void setPayAtHotelDate(String payAtHotelDate) {
        this.payAtHotelDate = payAtHotelDate;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public List<HotelBookingModel> getHotelBookingList() {
        return hotelBookingList;
    }

    public void setHotelBookingList(List<HotelBookingModel> hotelBookingList) {
        this.hotelBookingList = hotelBookingList;
    }

    public HotelDetailModel getHotelDetail() {
        return hotelDetail;
    }

    public void setHotelDetail(HotelDetailModel hotelDetail) {
        this.hotelDetail = hotelDetail;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public String getCheckInTo() {
        return checkInTo;
    }

    public void setCheckInTo(String checkInTo) {
        this.checkInTo = checkInTo;
    }

    public String getCheckOutTo() {
        return checkOutTo;
    }

    public void setCheckOutTo(String checkOutTo) {
        this.checkOutTo = checkOutTo;
    }

    public String getRoomImageUrl() {
        return roomImageUrl;
    }

    public void setRoomImageUrl(String roomImageUrl) {
        this.roomImageUrl = roomImageUrl;
    }

    public String getHotelImageUrl() {
        return hotelImageUrl;
    }

    public void setHotelImageUrl(String hotelImageUrl) {
        this.hotelImageUrl = hotelImageUrl;
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

    public String getAirportShuttle() {
        return airportShuttle;
    }

    public void setAirportShuttle(String airportShuttle) {
        this.airportShuttle = airportShuttle;
    }

    public String getHotelPhNo1() {
        return hotelPhNo1;
    }

    public void setHotelPhNo1(String hotelPhNo1) {
        this.hotelPhNo1 = hotelPhNo1;
    }

    public String getHotelPhNo2() {
        return hotelPhNo2;
    }

    public void setHotelPhNo2(String hotelPhNo2) {
        this.hotelPhNo2 = hotelPhNo2;
    }

    public String getHotelPhNo3() {
        return hotelPhNo3;
    }

    public void setHotelPhNo3(String hotelPhNo3) {
        this.hotelPhNo3 = hotelPhNo3;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getPerRate() {
        return perRate;
    }

    public void setPerRate(String perRate) {
        this.perRate = perRate;
    }



    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
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

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getRoomTypeDesc() {
        return roomTypeDesc;
    }

    public void setRoomTypeDesc(String roomTypeDesc) {
        this.roomTypeDesc = roomTypeDesc;
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

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public List<PayGateAccessModel> getPayGateAccessList() {
        return payGateAccessList;
    }

    public void setPayGateAccessList(List<PayGateAccessModel> payGateAccessList) {
        this.payGateAccessList = payGateAccessList;
    }

    public String getPayAtHotel() {
        return payAtHotel;
    }

    public void setPayAtHotel(String payAtHotel) {
        this.payAtHotel = payAtHotel;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(String finalRate) {
        this.finalRate = finalRate;
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

    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getHotelBookingId() {
        return hotelBookingId;
    }

    public void setHotelBookingId(String hotelBookingId) {
        this.hotelBookingId = hotelBookingId;
    }



    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
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

    public String getNoOfAdult() {
        return noOfAdult;
    }

    public void setNoOfAdult(String noOfAdult) {
        this.noOfAdult = noOfAdult;
    }

    public String getNoOfChild() {
        return noOfChild;
    }

    public void setNoOfChild(String noOfChild) {
        this.noOfChild = noOfChild;
    }

    public String getChildAges() {
        return childAges;
    }

    public void setChildAges(String childAges) {
        this.childAges = childAges;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(String customerDetailId) {
        this.customerDetailId = customerDetailId;
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


    @Override
    public String toString() {
        return "HotelBookingModel{" +
                "roomDetailId='" + roomDetailId + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", noOfRooms='" + noOfRooms + '\'' +
                ", noOfAdult='" + noOfAdult + '\'' +
                ", noOfChild='" + noOfChild + '\'' +
                ", childAges='" + childAges + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", customerDetailId='" + customerDetailId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", guestPhNo='" + guestPhNo + '\'' +
                ", guestEmailId='" + guestEmailId + '\'' +
                ", hotelBookingId='" + hotelBookingId + '\'' +
                ", configId='" + configId + '\'' +
                ", invoice='" + invoice + '\'' +
                ", payType='" + payType + '\'' +
                ", finalRate='" + finalRate + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", payAtHotel='" + payAtHotel + '\'' +
                ", roomTypeDesc='" + roomTypeDesc + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", totalBooked='" + totalBooked + '\'' +
                ", reserveType='" + reserveType + '\'' +
                ", cancelStatus='" + cancelStatus + '\'' +
                ", cancelDate='" + cancelDate + '\'' +
                ", effAdult='" + effAdult + '\'' +
                ", effChild='" + effChild + '\'' +
                ", noOfGuest='" + noOfGuest + '\'' +
                ", rate='" + rate + '\'' +
                ", extraChild='" + extraChild + '\'' +
                ", extraAdult='" + extraAdult + '\'' +
                ", actualRate='" + actualRate + '\'' +
                ", offerId='" + offerId + '\'' +
                ", offerName='" + offerName + '\'' +
                ", offerType='" + offerType + '\'' +
                ", offerAmount='" + offerAmount + '\'' +
                ", paid='" + paid + '\'' +
                ", actualAdult='" + actualAdult + '\'' +
                ", actualChild='" + actualChild + '\'' +
                ", totalGuest='" + totalGuest + '\'' +
                ", totalDays='" + totalDays + '\'' +
                ", payGateAccessList=" + payGateAccessList +
                ", hotelBookingList=" + hotelBookingList +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", perRate='" + perRate + '\'' +
                ", hotelPhNo1='" + hotelPhNo1 + '\'' +
                ", hotelPhNo2='" + hotelPhNo2 + '\'' +
                ", hotelPhNo3='" + hotelPhNo3 + '\'' +
                ", addressId='" + addressId + '\'' +
                ", airportShuttle='" + airportShuttle + '\'' +
                ", identificationNo='" + identificationNo + '\'' +
                ", arrivalDateTime='" + arrivalDateTime + '\'' +
                ", country='" + country + '\'' +
                ", roomImageUrl='" + roomImageUrl + '\'' +
                ", hotelImageUrl='" + hotelImageUrl + '\'' +
                ", checkInTo='" + checkInTo + '\'' +
                ", checkOutTo='" + checkOutTo + '\'' +
                ", specialRequest='" + specialRequest + '\'' +
                ", medium='" + medium + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", payAtHotelDate='" + payAtHotelDate + '\'' +
                ", paidDate='" + paidDate + '\'' +
                ", cancelFlag='" + cancelFlag + '\'' +
                ", hotelDetail=" + hotelDetail +
                '}';
    }
}
