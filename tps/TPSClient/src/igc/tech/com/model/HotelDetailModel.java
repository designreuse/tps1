package igc.tech.com.model;


public class HotelDetailModel {


    private String hotelDetailId, hotelName, starRating, hotelPhNo1, hotelPhNo2, hotelPhNo3,
    streetAddress, zipCode, hotelEmailId, addressId, url, totalRoom, active, tokenId, userDetailId, hotelType, lat, lng, description;
    private String userName, emailId;

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
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

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHotelEmailId() {
        return hotelEmailId;
    }

    public void setHotelEmailId(String hotelEmailId) {
        this.hotelEmailId = hotelEmailId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(String totalRoom) {
        this.totalRoom = totalRoom;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(String userDetailId) {
        this.userDetailId = userDetailId;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "HotelDetailModel{" +
                "hotelDetailId='" + hotelDetailId + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", starRating='" + starRating + '\'' +
                ", hotelPhNo1='" + hotelPhNo1 + '\'' +
                ", hotelPhNo2='" + hotelPhNo2 + '\'' +
                ", hotelPhNo3='" + hotelPhNo3 + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", hotelEmailId='" + hotelEmailId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", url='" + url + '\'' +
                ", totalRoom='" + totalRoom + '\'' +
                ", active='" + active + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", userDetailId='" + userDetailId + '\'' +
                '}';
    }
}
