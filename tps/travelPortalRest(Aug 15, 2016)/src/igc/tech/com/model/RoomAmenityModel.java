package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ganga on 4/19/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)

public class RoomAmenityModel {
    private String roomAmenityId, roomDetailId, amenityId, active;
    private String roomDesc, parentAmenityId, parentAmenityDesc, amenityDesc ;

    private String hotelDetailId;

    private String[] roomDetailIds;

    private List<RoomAmenityModel> roomAmenityModels;


    public RoomAmenityModel() {
    }

    public RoomAmenityModel(String roomAmenityId, String roomDetailId, String amenityId, String active, String roomDesc, String parentAmenityId, String parentAmenityDesc, String amenityDesc, String hotelDetailId) {
        this.roomAmenityId = roomAmenityId;
        this.roomDetailId = roomDetailId;
        this.amenityId = amenityId;
        this.active = active;
        this.roomDesc = roomDesc;
        this.parentAmenityId = parentAmenityId;
        this.parentAmenityDesc = parentAmenityDesc;
        this.amenityDesc = amenityDesc;
        this.hotelDetailId = hotelDetailId;
    }

    public String getRoomAmenityId() {
        return roomAmenityId;
    }

    public void setRoomAmenityId(String roomAmenityId) {
        this.roomAmenityId = roomAmenityId;
    }

    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
    }

    public String getAmenityId() {
        return amenityId;
    }

    public void setAmenityId(String amenityId) {
        this.amenityId = amenityId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public String getParentAmenityId() {
        return parentAmenityId;
    }

    public void setParentAmenityId(String parentAmenityId) {
        this.parentAmenityId = parentAmenityId;
    }

    public String getParentAmenityDesc() {
        return parentAmenityDesc;
    }

    public void setParentAmenityDesc(String parentAmenityDesc) {
        this.parentAmenityDesc = parentAmenityDesc;
    }

    public List<RoomAmenityModel> getRoomAmenityModels() {
        return roomAmenityModels;
    }

    public void setRoomAmenityModels(List<RoomAmenityModel> roomAmenityModels) {
        this.roomAmenityModels = roomAmenityModels;
    }

    public String getAmenityDesc() {
        return amenityDesc;
    }

    public void setAmenityDesc(String amenityDesc) {
        this.amenityDesc = amenityDesc;
    }

    public String[] getRoomDetailIds() {
        return roomDetailIds;
    }

    public void setRoomDetailIds(String[] roomDetailIds) {
        this.roomDetailIds = roomDetailIds;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    @Override
    public String toString() {
        return "RoomAmenityModel{" +
                "roomAmenityId='" + roomAmenityId + '\'' +
                ", roomDetailId='" + roomDetailId + '\'' +
                ", amenityId='" + amenityId + '\'' +
                ", active='" + active + '\'' +
                ", roomDesc='" + roomDesc + '\'' +
                ", parentAmenityId='" + parentAmenityId + '\'' +
                ", parentAmenityDesc='" + parentAmenityDesc + '\'' +
                ", amenityDesc='" + amenityDesc + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", roomDetailIds=" + Arrays.toString(roomDetailIds) +
                ", roomAmenityModels=" + roomAmenityModels +
                '}';
    }
}
