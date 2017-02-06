package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Ganga on 4/17/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RoomDetailModel {
    private String roomDetailId, roomTypeId, roomTypeDesc, bedTypeId, hotelDetailId, hotelName, starRating, regionName, countryName, customName,
            roomsProvided, remRoom, noOfBed, noOfGuest, rate, minNoOfGuest, discount,
            discountType, roomDimension, active, extraAdult, extraChild;

    private  String childAgeMax;
    private  String test;

    private  String childRate;
    private  String adultRate;
    private  String actualAdult;
    private  String actualChild;
    private  String totalGuest;
    private  String effChild;
    private  String effAdult;
    private String offerId;
    private String actualRate;
    private  String finalRate;

    private String totalDays;

    private String addressId;

    private String lat;
    private String lng;

    private  HotelFeatureModel hotelFeature;

    private List<RoomAmenityModel> roomAmenityList;

    private List<HotelActivityModel> hotelActivityList;

    private List<RoomImageModel> roomImageList;

    private ExtraBedModel extraBed;

    private String parentRoomTypeId;

    private HotelImageModel hotelImage;

    private List<RoomDetailModel> otherRoomsList;

    private List<HotelImageModel> hotelImageList;

    private  OfferModel offer;

    private List<NearPlacesModel> nearPlacesList;

    private List<RoomImportanceModel> roomImportanceList;

    private AddressModel address;

    public List<RoomImportanceModel> getRoomImportanceList() {
        return roomImportanceList;
    }

    public void setRoomImportanceList(List<RoomImportanceModel> roomImportanceList) {
        this.roomImportanceList = roomImportanceList;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
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

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public List<NearPlacesModel> getNearPlacesList() {
        return nearPlacesList;
    }

    public void setNearPlacesList(List<NearPlacesModel> nearPlacesList) {
        this.nearPlacesList = nearPlacesList;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getActualRate() {
        return actualRate;
    }

    public void setActualRate(String actualRate) {
        this.actualRate = actualRate;
    }

    public OfferModel getOffer() {
        return offer;
    }

    public void setOffer(OfferModel offer) {
        this.offer = offer;
    }

    public List<RoomImageModel> getRoomImageList() {
        return roomImageList;
    }

    public void setRoomImageList(List<RoomImageModel> roomImageList) {
        this.roomImageList = roomImageList;
    }

    public List<HotelImageModel> getHotelImageList() {
        return hotelImageList;
    }

    public void setHotelImageList(List<HotelImageModel> hotelImageList) {
        this.hotelImageList = hotelImageList;
    }

    public List<RoomDetailModel> getOtherRoomsList() {
        return otherRoomsList;
    }

    public void setOtherRoomsList(List<RoomDetailModel> otherRoomsList) {
        this.otherRoomsList = otherRoomsList;
    }

    public HotelImageModel getHotelImage() {
        return hotelImage;
    }

    public void setHotelImage(HotelImageModel hotelImage) {
        this.hotelImage = hotelImage;
    }

    public HotelFeatureModel getHotelFeature() {
        return hotelFeature;
    }

    public void setHotelFeature(HotelFeatureModel hotelFeature) {
        this.hotelFeature = hotelFeature;
    }

    public List<RoomAmenityModel> getRoomAmenityList() {
        return roomAmenityList;
    }

    public void setRoomAmenityList(List<RoomAmenityModel> roomAmenityList) {
        this.roomAmenityList = roomAmenityList;
    }

    public List<HotelActivityModel> getHotelActivityList() {
        return hotelActivityList;
    }

    public void setHotelActivityList(List<HotelActivityModel> hotelActivityList) {
        this.hotelActivityList = hotelActivityList;
    }

    public String getChildAgeMax() {
        return childAgeMax;
    }

    public void setChildAgeMax(String childAgeMax) {
        this.childAgeMax = childAgeMax;
    }

    public String getChildRate() {
        return childRate;
    }

    public void setChildRate(String childRate) {
        this.childRate = childRate;
    }

    public String getAdultRate() {
        return adultRate;
    }

    public void setAdultRate(String adultRate) {
        this.adultRate = adultRate;
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

    public String getEffChild() {
        return effChild;
    }

    public void setEffChild(String effChild) {
        this.effChild = effChild;
    }

    public String getEffAdult() {
        return effAdult;
    }

    public void setEffAdult(String effAdult) {
        this.effAdult = effAdult;
    }

    public String getFinalRate() {
        return finalRate;
    }

    public void setFinalRate(String finalRate) {
        this.finalRate = finalRate;
    }

    public ExtraBedModel getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(ExtraBedModel extraBed) {
        this.extraBed = extraBed;
    }

    public String getRoomTypeDesc() {
        return roomTypeDesc;
    }

    public void setRoomTypeDesc(String roomTypeDesc) {
        this.roomTypeDesc = roomTypeDesc;
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

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRemRoom() {
        return remRoom;
    }

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    public void setRemRoom(String remRoom) {
        this.remRoom = remRoom;
    }

    public String getExtraAdult() {
        return extraAdult;
    }

    public void setExtraAdult(String extraAdult) {
        this.extraAdult = extraAdult;
    }

    public String getExtraChild() {
        return extraChild;
    }

    public void setExtraChild(String extraChild) {
        this.extraChild = extraChild;
    }

    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getBedTypeId() {
        return bedTypeId;
    }

    public void setBedTypeId(String bedTypeId) {
        this.bedTypeId = bedTypeId;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getRoomsProvided() {
        return roomsProvided;
    }

    public void setRoomsProvided(String roomsProvided) {
        this.roomsProvided = roomsProvided;
    }

    public String getNoOfBed() {
        return noOfBed;
    }

    public void setNoOfBed(String noOfBed) {
        this.noOfBed = noOfBed;
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

    public String getMinNoOfGuest() {
        return minNoOfGuest;
    }

    public void setMinNoOfGuest(String minNoOfGuest) {
        this.minNoOfGuest = minNoOfGuest;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getRoomDimension() {
        return roomDimension;
    }

    public void setRoomDimension(String roomDimension) {
        this.roomDimension = roomDimension;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getParentRoomTypeId() {
        return parentRoomTypeId;
    }

    public void setParentRoomTypeId(String parentRoomTypeId) {
        this.parentRoomTypeId = parentRoomTypeId;
    }


    @Override
    public String toString() {
        return "RoomDetailModel{" +
                "roomDetailId='" + roomDetailId + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", roomTypeDesc='" + roomTypeDesc + '\'' +
                ", bedTypeId='" + bedTypeId + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", starRating='" + starRating + '\'' +
                ", regionName='" + regionName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", customName='" + customName + '\'' +
                ", roomsProvided='" + roomsProvided + '\'' +
                ", remRoom='" + remRoom + '\'' +
                ", noOfBed='" + noOfBed + '\'' +
                ", noOfGuest='" + noOfGuest + '\'' +
                ", rate='" + rate + '\'' +
                ", minNoOfGuest='" + minNoOfGuest + '\'' +
                ", discount='" + discount + '\'' +
                ", discountType='" + discountType + '\'' +
                ", roomDimension='" + roomDimension + '\'' +
                ", active='" + active + '\'' +
                ", extraAdult='" + extraAdult + '\'' +
                ", extraChild='" + extraChild + '\'' +
                ", childAgeMax='" + childAgeMax + '\'' +
                ", test='" + test + '\'' +
                ", childRate='" + childRate + '\'' +
                ", adultRate='" + adultRate + '\'' +
                ", actualAdult='" + actualAdult + '\'' +
                ", actualChild='" + actualChild + '\'' +
                ", totalGuest='" + totalGuest + '\'' +
                ", effChild='" + effChild + '\'' +
                ", effAdult='" + effAdult + '\'' +
                ", offerId='" + offerId + '\'' +
                ", actualRate='" + actualRate + '\'' +
                ", finalRate='" + finalRate + '\'' +
                ", totalDays='" + totalDays + '\'' +
                ", addressId='" + addressId + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", hotelFeature=" + hotelFeature +
                ", roomAmenityList=" + roomAmenityList +
                ", hotelActivityList=" + hotelActivityList +
                ", roomImageList=" + roomImageList +
                ", extraBed=" + extraBed +
                ", parentRoomTypeId='" + parentRoomTypeId + '\'' +
                ", hotelImage=" + hotelImage +
                ", otherRoomsList=" + otherRoomsList +
                ", hotelImageList=" + hotelImageList +
                ", offer=" + offer +
                ", nearPlacesList=" + nearPlacesList +
                ", address=" + address +
                '}';
    }
}
