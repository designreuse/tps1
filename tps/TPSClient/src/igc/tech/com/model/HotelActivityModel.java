package igc.tech.com.model;

/**
 * Created by Ganga on 4/15/2016.
 */
public class HotelActivityModel {

    private String hotelActivityId, hotelDetailId, activityId, type, active;
    private String activityDesc, chargeOption, parentActivityId, parentActivityDesc, activityList;

    public String getHotelActivityId() {
        return hotelActivityId;
    }

    public void setHotelActivityId(String hotelActivityId) {
        this.hotelActivityId = hotelActivityId;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getActivityDesc() {
        return activityDesc;
    }

    public void setActivityDesc(String activityDesc) {
        this.activityDesc = activityDesc;
    }

    public String getChargeOption() {
        return chargeOption;
    }

    public void setChargeOption(String chargeOption) {
        this.chargeOption = chargeOption;
    }

    public String getParentActivityId() {
        return parentActivityId;
    }

    public void setParentActivityId(String parentActivityId) {
        this.parentActivityId = parentActivityId;
    }

    public String getParentActivityDesc() {
        return parentActivityDesc;
    }

    public void setParentActivityDesc(String parentActivityDesc) {
        this.parentActivityDesc = parentActivityDesc;
    }

    public String getActivityList() {
        return activityList;
    }

    public void setActivityList(String activityList) {
        this.activityList = activityList;
    }

    @Override
    public String toString() {
        return "HotelActivityModel{" +
                "hotelActivityId='" + hotelActivityId + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", activityId='" + activityId + '\'' +
                ", type='" + type + '\'' +
                ", active='" + active + '\'' +
                ", activityDesc='" + activityDesc + '\'' +
                ", chargeOption='" + chargeOption + '\'' +
                ", parentActivityId='" + parentActivityId + '\'' +
                ", parentActivityDesc='" + parentActivityDesc + '\'' +
                '}';
    }
}
