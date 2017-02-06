package igc.tech.com.model;

/**
 * Created by Ganga on 4/1/2016.
 */
public class RoomImportanceModel {

    private String roomImportanceId, rulesId, roomDetailId, active;
    private String hotelDetailId;

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

    public String getRoomDetailId() {
        return roomDetailId;
    }

    public void setRoomDetailId(String roomDetailId) {
        this.roomDetailId = roomDetailId;
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

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    @Override
    public String toString() {
        return "RoomImportanceModel{" +
                "roomImportanceId='" + roomImportanceId + '\'' +
                ", rulesId='" + rulesId + '\'' +
                ", roomDetailId='" + roomDetailId + '\'' +
                ", active='" + active + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", rulesDesc='" + rulesDesc + '\'' +
                ", roomDesc='" + roomDesc + '\'' +
                '}';
    }
}
