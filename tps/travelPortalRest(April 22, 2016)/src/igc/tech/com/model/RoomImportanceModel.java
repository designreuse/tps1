package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ganga on 4/1/2016.
 */
@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class RoomImportanceModel {

    private String roomImportanceId, rulesId, roomTypeId;

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
