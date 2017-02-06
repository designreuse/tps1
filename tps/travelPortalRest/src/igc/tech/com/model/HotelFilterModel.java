package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by tilak on 6/8/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelFilterModel extends ResponseModel {

    private String roomDetailId;
    private String searchValue;
    private String checkInDate;
    private String checkOutDate;
    private String noOfRooms;
    private String noOfAdult;
    private String noOfChild;
    private String childAges;
    private String activities;
    private String amenities;
    private String fromPrice;
    private String toPrice;

    private  String hotelDetailId;
    private String type;
    private String sortingType;
    private String starRange;

    private String pageNo;
    private String offSet;

    private String totalHotels;
    private  String overPage;
    private  String platform;
    private  String searchKey;
    private  String offer;
    private  String currencyDesc;


    private List<AddressModel> addressList;

    private List<HotelDetailModel> hotelDetailList;

    private List<RoomDetailModel> roomDetailList;

    private   List<ActivityModel> activityList;

    private   List<AmenityModel> amenityList;

    private   List<HotelDetailModel> starList;


    public String getCurrencyDesc() {
        return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc) {
        this.currencyDesc = currencyDesc;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getPlatform() {
        return platform;
    }

    public List<HotelDetailModel> getStarList() {
        return starList;
    }

    public void setStarList(List<HotelDetailModel> starList) {
        this.starList = starList;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<ActivityModel> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<ActivityModel> activityList) {
        this.activityList = activityList;
    }

    public List<AmenityModel> getAmenityList() {
        return amenityList;
    }

    public void setAmenityList(List<AmenityModel> amenityList) {
        this.amenityList = amenityList;
    }

    public String getOverPage() {
        return overPage;
    }

    public void setOverPage(String overPage) {
        this.overPage = overPage;
    }

    public List<RoomDetailModel> getRoomDetailList() {
        return roomDetailList;
    }

    public void setRoomDetailList(List<RoomDetailModel> roomDetailList) {
        this.roomDetailList = roomDetailList;
    }

    public String getTotalHotels() {
        return totalHotels;
    }

    public void setTotalHotels(String totalHotels) {
        this.totalHotels = totalHotels;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getOffSet() {
        return offSet;
    }

    public void setOffSet(String offSet) {
        this.offSet = offSet;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getSortingType() {
        return sortingType;
    }

    public void setSortingType(String sortingType) {
        this.sortingType = sortingType;
    }

    public String getStarRange() {
        return starRange;
    }

    public void setStarRange(String starRange) {
        this.starRange = starRange;
    }

    public List<HotelDetailModel> getHotelDetailList() {
        return hotelDetailList;
    }

    public void setHotelDetailList(List<HotelDetailModel> hotelDetailList) {
        this.hotelDetailList = hotelDetailList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AddressModel> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressModel> addressList) {
        this.addressList = addressList;
    }

    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
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

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(String fromPrice) {
        this.fromPrice = fromPrice;
    }

    public String getToPrice() {
        return toPrice;
    }

    public void setToPrice(String toPrice) {
        this.toPrice = toPrice;
    }

    @Override
    public String toString() {
        return "HotelFilterModel{" +
                "roomDetailId='" + roomDetailId + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", noOfRooms='" + noOfRooms + '\'' +
                ", noOfAdult='" + noOfAdult + '\'' +
                ", noOfChild='" + noOfChild + '\'' +
                ", childAges='" + childAges + '\'' +
                ", activities='" + activities + '\'' +
                ", amenities='" + amenities + '\'' +
                ", fromPrice='" + fromPrice + '\'' +
                ", toPrice='" + toPrice + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", type='" + type + '\'' +
                ", sortingType='" + sortingType + '\'' +
                ", starRange='" + starRange + '\'' +
                ", pageNo='" + pageNo + '\'' +
                ", offSet='" + offSet + '\'' +
                ", totalHotels='" + totalHotels + '\'' +
                ", overPage='" + overPage + '\'' +
                ", platform='" + platform + '\'' +
                ", addressList=" + addressList +
                ", hotelDetailList=" + hotelDetailList +
                ", roomDetailList=" + roomDetailList +
                ", activityList=" + activityList +
                ", amenityList=" + amenityList +
                '}';
    }
}
