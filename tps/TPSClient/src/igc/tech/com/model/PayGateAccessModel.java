package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PayGateAccessModel {

    private String payGateAccessId, payGateDesc, type, active;
    private  String image;

    public PayGateAccessModel() {
    }

    public PayGateAccessModel(String payGateAccessId, String payGateDesc, String type, String active) {
        this.payGateAccessId = payGateAccessId;
        this.payGateDesc = payGateDesc;
        this.type = type;
        this.active = active;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public String toString() {
        return "PayGateAccessModel{" +
                "payGateAccessId='" + payGateAccessId + '\'' +
                ", payGateDesc='" + payGateDesc + '\'' +
                ", type='" + type + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
