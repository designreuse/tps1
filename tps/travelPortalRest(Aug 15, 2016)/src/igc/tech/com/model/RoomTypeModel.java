package igc.tech.com.model;

/**
 * Created by Ganga on 4/17/2016.
 */
public class RoomTypeModel {

    private String roomTypeId, parentRoomTypeId, roomTypeDesc, active;

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getParentRoomTypeId() {
        return parentRoomTypeId;
    }

    public void setParentRoomTypeId(String parentRoomTypeId) {
        this.parentRoomTypeId = parentRoomTypeId;
    }

    public String getRoomTypeDesc() {
        return roomTypeDesc;
    }

    public void setRoomTypeDesc(String roomTypeDesc) {
        this.roomTypeDesc = roomTypeDesc;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
