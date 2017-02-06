package igc.tech.com.model;

import java.util.List;
import java.util.Map;

/**
 * Created by Ganga on 4/15/2016.
 */
public class ActivityModel {

    private String activityId, parentActivityId, activityDesc, chargeOption, active, webPrior, mobPrior, icon, image, deletedFlag;

    private List<ActivityModel> activityModels;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getParentActivityId() {
        return parentActivityId;
    }

    public void setParentActivityId(String parentActivityId) {
        this.parentActivityId = parentActivityId;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public List<ActivityModel> getActivityModels() {
        return activityModels;
    }

    public void setActivityModels(List<ActivityModel> activityModels) {
        this.activityModels = activityModels;
    }

    public String getWebPrior() {
        return webPrior;
    }

    public void setWebPrior(String webPrior) {
        this.webPrior = webPrior;
    }

    public String getMobPrior() {
        return mobPrior;
    }

    public void setMobPrior(String mobPrior) {
        this.mobPrior = mobPrior;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }


    @Override
    public String toString() {
        return "ActivityModel{" +
                "activityId='" + activityId + '\'' +
                ", parentActivityId='" + parentActivityId + '\'' +
                ", activityDesc='" + activityDesc + '\'' +
                ", chargeOption='" + chargeOption + '\'' +
                ", active='" + active + '\'' +
                ", webPrior='" + webPrior + '\'' +
                ", mobPrior='" + mobPrior + '\'' +
                ", icon='" + icon + '\'' +
                ", activityModels=" + activityModels +
                '}';
    }
}
