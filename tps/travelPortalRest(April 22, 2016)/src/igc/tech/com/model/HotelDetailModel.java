package igc.tech.com.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HotelDetailModel {

    private String hotelDetailId;
    private String hotelName;
    private String  hotelPhNo1;
    private String  hotelPhNo2;
    private String  hotelPhNo3;
    private String  hotelAddress;
    private String  hotelEmailId;
    private String  clientDetailId;
    private String  clientName;
    private String  areaId;
    private String  areaName;
    private String  regionName;
    private String  countryName;
    private String  user;
    private String  url;
    private String  flag;
    private  String cheapRate;

    private List<HotelFacilityModel> hotelFacilityModels;

    private List<HotelRulesModel> hotelRulesModels;

    private List<RoomTypeModel> roomTypeModels;

    /////////////////////////////

    private List<HotelFacilityModel> hotelFacilities;

    private List<RoomFacilityModel> roomFacilities;

    private List<BedTypeModel> bedTypes;

    private List<RoomTypeModel> roomTypes;

    public List<RoomTypeModel> getRoomTypeModels() {
        return roomTypeModels;
    }

    public void setRoomTypeModels(List<RoomTypeModel> roomTypeModels) {
        this.roomTypeModels = roomTypeModels;
    }

    public List<HotelRulesModel> getHotelRulesModels() {
        return hotelRulesModels;
    }

    public void setHotelRulesModels(List<HotelRulesModel> hotelRulesModels) {
        this.hotelRulesModels = hotelRulesModels;
    }

    public List<HotelFacilityModel> getHotelFacilityModels() {
        return hotelFacilityModels;
    }

    public void setHotelFacilityModels(List<HotelFacilityModel> hotelFacilityModels) {
        this.hotelFacilityModels = hotelFacilityModels;
    }



    public List<BedTypeModel> getBedTypes() {
        return bedTypes;
    }

    public void setBedTypes(List<BedTypeModel> bedTypes) {
        this.bedTypes = bedTypes;
    }

    public List<RoomFacilityModel> getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(List<RoomFacilityModel> roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public List<RoomTypeModel> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomTypeModel> roomTypes) {
        this.roomTypes = roomTypes;
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

    public String getClientDetailId() {
        return clientDetailId;
    }

    public void setClientDetailId(String clientDetailId) {
        this.clientDetailId = clientDetailId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCheapRate() {
        return cheapRate;
    }

    public void setCheapRate(String cheapRate) {
        this.cheapRate = cheapRate;
    }

    public List<HotelFacilityModel> getHotelFacilities() {
        return hotelFacilities;
    }

    public void setHotelFacilities(List<HotelFacilityModel> hotelFacilities) {
        this.hotelFacilities = hotelFacilities;
    }

    @Override
    public String toString() {
        return "HotelDetailModel{" +
                "hotelDetailId='" + hotelDetailId + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", hotelPhNo1='" + hotelPhNo1 + '\'' +
                ", hotelPhNo2='" + hotelPhNo2 + '\'' +
                ", hotelPhNo3='" + hotelPhNo3 + '\'' +
                ", hotelAddress='" + hotelAddress + '\'' +
                ", hotelEmailId='" + hotelEmailId + '\'' +
                ", areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", regionName='" + regionName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", user='" + user + '\'' +
                ", url='" + url + '\'' +
                ", flag='" + flag + '\'' +
                ", cheapRate='" + cheapRate + '\'' +
                ", hotelFacilities=" + hotelFacilities +
                ", roomTypes=" + roomTypes +
                '}';
    }
}
