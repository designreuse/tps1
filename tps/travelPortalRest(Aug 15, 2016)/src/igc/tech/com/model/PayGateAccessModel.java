package igc.tech.com.model;

/**
 * Created by Ganga on 7/17/2016.
 */
public class PayGateAccessModel {

    private String payGateAccessId, payGateDesc, type, active;

    public PayGateAccessModel() {
    }

    public PayGateAccessModel(String payGateAccessId, String payGateDesc, String type, String active) {
        this.payGateAccessId = payGateAccessId;
        this.payGateDesc = payGateDesc;
        this.type = type;
        this.active = active;
    }

    public String getPayGateAccessId() {
        return payGateAccessId;
    }

    public void setPayGateAccessId(String payGateAccessId) {
        this.payGateAccessId = payGateAccessId;
    }

    public String getPayGateDesc() {
        return payGateDesc;
    }

    public void setPayGateDesc(String payGateDesc) {
        this.payGateDesc = payGateDesc;
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
}
