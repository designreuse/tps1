package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RoomFacilityAccessModel {

    private String roomFacilityAccessId;
    private String roomTypeId;
    private String roomTypeDesc;
    private String roomFacilityId;
    private String roomFacilityDesc;
    private String hotelName;
    private String areaName;
    private String regionName;
    private String countryName;
    private String user;
    private List<RoomFacilityAccessModel> roomFacilityAccess;


    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getRoomFacilityId() {
        return roomFacilityId;
    }

    public void setRoomFacilityId(String roomFacilityId) {
        this.roomFacilityId = roomFacilityId;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRoomFacilityAccessId() {
        return roomFacilityAccessId;
    }

    public void setRoomFacilityAccessId(String roomFacilityAccessId) {
        this.roomFacilityAccessId = roomFacilityAccessId;
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

    public String getRoomFacilityDesc() {
        return roomFacilityDesc;
    }

    public void setRoomFacilityDesc(String roomFacilityDesc) {
        this.roomFacilityDesc = roomFacilityDesc;
    }

    public List<RoomFacilityAccessModel> getRoomFacilityAccess() {
        return roomFacilityAccess;
    }

    public void setRoomFacilityAccess(List<RoomFacilityAccessModel> roomFacilityAccess) {
        this.roomFacilityAccess = roomFacilityAccess;
    }

    public void setNull(boolean roomFacilityAccessId, boolean roomTypeId, boolean roomTypeDesc, boolean roomFacilityId,
                        boolean roomFacilityDesc, boolean hotelName, boolean regionName, boolean countryName, boolean user) {

        if (roomFacilityAccessId) {
            this.roomFacilityAccessId = null;
        }
        if (roomTypeId) {
            this.roomTypeId = null;
        }
        if (roomTypeDesc) {
            this.roomTypeDesc = null;
        }
        if (roomFacilityId) {
            this.roomFacilityId = null;
        }
        if (roomFacilityDesc) {
            this.roomFacilityDesc = null;
        }
        if (hotelName) {
            this.hotelName = null;
        }

        if (regionName) {
            this.regionName = null;
        }

        if (countryName) {
            this.countryName = null;
        }

        if (user) {
            this.user = null;
        }


    }
}
