package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BedTypeAccessModel {

    private String bedTypeAccessId;
    private String roomTypeId;
    private String roomTypeDesc;
    private String bedTypeId;
    private String bedTypeDesc;
    private String hotelName;
    private String areaName;
    private String regionName;
    private String countryName;
    private String user;

    private List<BedTypeAccessModel> bedTypeAccess;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBedTypeAccessId() {
        return bedTypeAccessId;
    }

    public void setBedTypeAccessId(String bedTypeAccessId) {
        this.bedTypeAccessId = bedTypeAccessId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeDesc() {
        return roomTypeDesc;
    }

    public void setRoomTypeDesc(String roomTypeDesc) {
        this.roomTypeDesc = roomTypeDesc;
    }

    public String getBedTypeId() {
        return bedTypeId;
    }

    public void setBedTypeId(String bedTypeId) {
        this.bedTypeId = bedTypeId;
    }

    public String getBedTypeDesc() {
        return bedTypeDesc;
    }

    public void setBedTypeDesc(String bedTypeDesc) {
        this.bedTypeDesc = bedTypeDesc;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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

    public List<BedTypeAccessModel> getBedTypeAccess() {
        return bedTypeAccess;
    }

    public void setBedTypeAccess(List<BedTypeAccessModel> bedTypeAccess) {
        this.bedTypeAccess = bedTypeAccess;
    }
}
