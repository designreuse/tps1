package igc.tech.com.model;

/**
 * Created by Ganga on 4/1/2016.
 */
public class RoomImportanceModel {

    private String roomImportanceId, rulesId, roomTypeId, active;

    private String rulesDesc, roomDesc;

    public String getRoomImportanceId() {
        return roomImportanceId;
    }

    public void setRoomImportanceId(String roomImportanceId) {
        this.roomImportanceId = roomImportanceId;
    }

    public String getRulesId() {
        return rulesId;
    }

    public void setRulesId(String rulesId) {
        this.rulesId = rulesId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRulesDesc() {
        return rulesDesc;
    }

    public void setRulesDesc(String rulesDesc) {
        this.rulesDesc = rulesDesc;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    @Override
    public String toString() {
        return "RoomImportanceModel{" +
                "roomImportanceId='" + roomImportanceId + '\'' +
                ", rulesId='" + rulesId + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", rulesDesc='" + rulesDesc + '\'' +
                ", roomDesc='" + roomDesc + '\'' +
                '}';
    }
}
