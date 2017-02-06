package igc.tech.com.model;

/**
 * Created by Ganga on 9/27/2016.
 */
public class PushContentDataModel {
    private String pushContentDataId, hotelDetailId, status, remarks;

    public String getPushContentDataId() {
        return pushContentDataId;
    }

    public void setPushContentDataId(String pushContentDataId) {
        this.pushContentDataId = pushContentDataId;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
