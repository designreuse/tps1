package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ganga on 8/24/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailTpsModel {
    private String emailTpsId, emailAddress, active;

    public EmailTpsModel() {
    }

    public EmailTpsModel(String emailTpsId, String emailAddress, String active) {
        this.emailTpsId = emailTpsId;
        this.emailAddress = emailAddress;
        this.active = active;
    }

    public String getEmailTpsId() {
        return emailTpsId;
    }

    public void setEmailTpsId(String emailTpsId) {
        this.emailTpsId = emailTpsId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "EmailTpsModel{" +
                "emailTpsId='" + emailTpsId + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
