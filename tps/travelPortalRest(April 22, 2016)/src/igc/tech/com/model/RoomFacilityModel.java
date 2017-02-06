package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RoomFacilityModel {

    private String roomFacilityId, roomTypeId, facilityId, active;

    private String facilityDesc, roomDesc;

    public String getRoomFacilityId() {
        return roomFacilityId;
    }

    public void setRoomFacilityId(String roomFacilityId) {
        this.roomFacilityId = roomFacilityId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getFacilityDesc() {
        return facilityDesc;
    }

    public void setFacilityDesc(String facilityDesc) {
        this.facilityDesc = facilityDesc;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    @Override
    public String toString() {
        return "RoomFacilityModel{" +
                "roomFacilityId='" + roomFacilityId + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", facilityId='" + facilityId + '\'' +
                ", facilityDesc='" + facilityDesc + '\'' +
                ", roomDesc='" + roomDesc + '\'' +
                '}';
    }
}
