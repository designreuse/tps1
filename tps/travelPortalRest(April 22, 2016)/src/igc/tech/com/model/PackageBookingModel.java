package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PackageBookingModel {

    private String packageBookingId;
    private String referenceNo;
    private String amount;
    private String discountAmount;
    private String totalAmount;
    private String arrivalDate;
    private String departDate;
    private String noOfPerson;
    private String adult;
    private String child;
    private String additionalInfo;
    private String referedBy;
    private String bookingStatus;
    private String hashCode;
    private String email;
    private String customerTitle;
    private String firstName;
    private String middleName;
    private String lastName;
    private String contactNo;
    private String passportNo;
    private String customerType;
    private String availableDateRateId;
    private String customerDetailId;

    private  String payCategory;

    private String availableDate;
    private String Rate;
    private String packageName;
    private String totalDays;

    private String user;

    public String getPayCategory() {
        return payCategory;
    }

    public void setPayCategory(String payCategory) {
        this.payCategory = payCategory;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(String availableDate) {
        this.availableDate = availableDate;
    }

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public String getPackageBookingId() {
        return packageBookingId;
    }

    public void setPackageBookingId(String packageBookingId) {
        this.packageBookingId = packageBookingId;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(String noOfPerson) {
        this.noOfPerson = noOfPerson;
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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getReferedBy() {
        return referedBy;
    }

    public void setReferedBy(String referedBy) {
        this.referedBy = referedBy;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAvailableDateRateId() {
        return availableDateRateId;
    }

    public void setAvailableDateRateId(String availableDateRateId) {
        this.availableDateRateId = availableDateRateId;
    }

    public String getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(String customerDetailId) {
        this.customerDetailId = customerDetailId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PackageBookingModel{" +
                "packageBookingId='" + packageBookingId + '\'' +
                ", referenceNo='" + referenceNo + '\'' +
                ", amount='" + amount + '\'' +
                ", discountAmount='" + discountAmount + '\'' +
                ", totalAmount='" + totalAmount + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", departDate='" + departDate + '\'' +
                ", noOfPerson='" + noOfPerson + '\'' +
                ", adult='" + adult + '\'' +
                ", child='" + child + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", referedBy='" + referedBy + '\'' +
                ", bookingStatus='" + bookingStatus + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", email='" + email + '\'' +
                ", customerTitle='" + customerTitle + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", customerType='" + customerType + '\'' +
                ", availableDateRateId='" + availableDateRateId + '\'' +
                ", customerDetailId='" + customerDetailId + '\'' +
                ", availableDate='" + availableDate + '\'' +
                ", Rate='" + Rate + '\'' +
                ", packageName='" + packageName + '\'' +
                ", totalDays='" + totalDays + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
