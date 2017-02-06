package igc.tech.com.model;

/**
 * Created by Ganga on 4/17/2016.
 */
public class RoomDetailModel {
    private String roomDetailId, roomTypeId, bedTypeId, hotelDetailId, customName,
            roomsProvided, noOfBed, noOfGuest, rate, minNoOfGuest, discount,
            dicountType, roomDimension, active, extraAdult, extraChild, childAgeMax, childRate, adultRate;
    private String parentRoomTypeId, roomTypeDesc;

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

    public String getDicountType() {
        return dicountType;
    }

    public void setDicountType(String dicountType) {
        this.dicountType = dicountType;
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

    public String getRoomTypeDesc() {
        return roomTypeDesc;
    }

    public void setRoomTypeDesc(String roomTypeDesc) {
        this.roomTypeDesc = roomTypeDesc;
    }

    @Override
    public String toString() {
        return "RoomDetailModel{" +
                "roomDetailId='" + roomDetailId + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", bedTypeId='" + bedTypeId + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", customName='" + customName + '\'' +
                ", roomsProvided='" + roomsProvided + '\'' +
                ", noOfBed='" + noOfBed + '\'' +
                ", noOfGuest='" + noOfGuest + '\'' +
                ", rate='" + rate + '\'' +
                ", minNoOfGuest='" + minNoOfGuest + '\'' +
                ", discount='" + discount + '\'' +
                ", dicountType='" + dicountType + '\'' +
                ", roomDimension='" + roomDimension + '\'' +
                ", active='" + active + '\'' +
                ", extraAdult='" + extraAdult + '\'' +
                ", extraChild='" + extraChild + '\'' +
                ", parentRoomTypeId='" + parentRoomTypeId + '\'' +
                '}';
    }
}
