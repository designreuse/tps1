package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HotelBookingModel {


    private String customerTitle;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNo;
    private String passportNo;
    private String customerType;


    private String referenceNo;
    private String hotelBookingId;
    private String roomTypeId;
    private String roomDesc;
    private String rate;
    private String adult;
    private String child;
    private String checkInDate;
    private String checkOutDate;
    private String countryId;
    private String countryName;
    private String company;
    private String city;
    private String postalCode;
    private String licenseNo;
    private String airportPickUp;

    private String customerDetailId;

    private String bookingStatus;
    private String hashCode;

    private String amount;
    private String discountAmount;
    private String totalAmount;

    private  String payCategory;


    private String hotelName;
    private String hotelPhNo1;
    private String hotelPhNo2;
    private String hotelPhNo3;
    private String hotelAddress;
    private String hotelEmailId;

    private String user;

    public String getPayCategory() {
        return payCategory;
    }

    public void setPayCategory(String payCategory) {
        this.payCategory = payCategory;
    }

    public String getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(String customerDetailId) {
        this.customerDetailId = customerDetailId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }


    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHotelBookingId() {
        return hotelBookingId;
    }

    public void setHotelBookingId(String hotelBookingId) {
        this.hotelBookingId = hotelBookingId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public String getHotelEmailId() {
        return hotelEmailId;
    }

    public void setHotelEmailId(String hotelEmailId) {
        this.hotelEmailId = hotelEmailId;
    }


    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
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

    public String getCustomerTitle() {
        return customerTitle;
    }

    public void setCustomerTitle(String customerTitle) {
        this.customerTitle = customerTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAirportPickUp() {
        return airportPickUp;
    }

    public void setAirportPickUp(String airportPickUp) {
        this.airportPickUp = airportPickUp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "HotelBookingModel{" +
                "customerTitle='" + customerTitle + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", customerType='" + customerType + '\'' +
                ", referenceNo='" + referenceNo + '\'' +
                ", hotelBookingId='" + hotelBookingId + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", roomDesc='" + roomDesc + '\'' +
                ", rate='" + rate + '\'' +
                ", adult='" + adult + '\'' +
                ", child='" + child + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", airportPickUp='" + airportPickUp + '\'' +
                ", customerDetailId='" + customerDetailId + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", amount='" + amount + '\'' +
                ", discountAmount='" + discountAmount + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelPhNo1='" + hotelPhNo1 + '\'' +
                ", hotelPhNo2='" + hotelPhNo2 + '\'' +
                ", hotelPhNo3='" + hotelPhNo3 + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelEmailId='" + hotelEmailId + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
