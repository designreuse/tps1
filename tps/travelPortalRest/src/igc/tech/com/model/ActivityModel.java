package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Ganga on 4/15/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityModel {

    private String activityId, parentActivityId, activityDesc, chargeOption, active;

    private  String webPrior;
    private  String mobPrior;
    private  String icon;
    private  String total;
    private  String image;
    private List<ActivityModel> activityList;

    public ActivityModel() {
    }

    public List<ActivityModel> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<ActivityModel> activityList) {
        this.activityList = activityList;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

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
                ", total='" + total + '\'' +
                ", image='" + image + '\'' +
                ", activityList=" + activityList +
                '}';
    }
}
