package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

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
                '}';
    }
}
