package igc.tech.com.model;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HotelDetailModel {


    private String hotelDetailId, hotelName, starRating, hotelPhNo1, hotelPhNo2, hotelPhNo3,
    streetAddress, zipCode, hotelEmailId, areaId, url, totalRoom, active, tokenId ,userDetailId, addressId, lat, lng;

    private  RoomDetailModel roomDetail;

    private  String total;

    private List<RoomDetailModel> roomDetailList;

    private AddressModel address;

    private  HotelFeatureModel hotelFeature;

    private List<HotelActivityModel> hotelActivityList;

    private List<HotelImageModel> hotelImageList;

    private List<NearPlacesModel> nearPlacesList;

    private List<HotelRulesModel> hotelRulesList;


    public HotelDetailModel() {
    }

    public HotelDetailModel(String hotelDetailId, String hotelName) {
        this.hotelDetailId = hotelDetailId;
        this.hotelName = hotelName;
    }

    public List<HotelRulesModel> getHotelRulesList() {
        return hotelRulesList;
    }

    public void setHotelRulesList(List<HotelRulesModel> hotelRulesList) {
        this.hotelRulesList = hotelRulesList;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public RoomDetailModel getRoomDetail() {
        return roomDetail;
    }

    public void setRoomDetail(RoomDetailModel roomDetail) {
        this.roomDetail = roomDetail;
    }

    public List<RoomDetailModel> getRoomDetailList() {
        return roomDetailList;
    }

    public void setRoomDetailList(List<RoomDetailModel> roomDetailList) {
        this.roomDetailList = roomDetailList;
    }

    public HotelFeatureModel getHotelFeature() {
        return hotelFeature;
    }

    public void setHotelFeature(HotelFeatureModel hotelFeature) {
        this.hotelFeature = hotelFeature;
    }

    public List<HotelActivityModel> getHotelActivityList() {
        return hotelActivityList;
    }

    public void setHotelActivityList(List<HotelActivityModel> hotelActivityList) {
        this.hotelActivityList = hotelActivityList;
    }

    public List<HotelImageModel> getHotelImageList() {
        return hotelImageList;
    }

    public void setHotelImageList(List<HotelImageModel> hotelImageList) {
        this.hotelImageList = hotelImageList;
    }

    public List<NearPlacesModel> getNearPlacesList() {
        return nearPlacesList;
    }

    public void setNearPlacesList(List<NearPlacesModel> nearPlacesList) {
        this.nearPlacesList = nearPlacesList;
    }

    public String getUserDetailId() {
        return userDetailId;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public void setUserDetailId(String userDetailId) {
        this.userDetailId = userDetailId;
    }

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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
                ", areaId='" + areaId + '\'' +
                ", url='" + url + '\'' +
                ", totalRoom='" + totalRoom + '\'' +
                ", active='" + active + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", userDetailId='" + userDetailId + '\'' +
                ", addressId='" + addressId + '\'' +
                ", roomDetail=" + roomDetail +
                ", roomDetailList=" + roomDetailList +
                ", address=" + address +
                ", hotelFeature=" + hotelFeature +
                ", hotelActivityList=" + hotelActivityList +
                ", hotelImageList=" + hotelImageList +
                ", nearPlacesList=" + nearPlacesList +
                '}';
    }
}
