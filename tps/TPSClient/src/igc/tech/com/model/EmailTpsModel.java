package igc.tech.com.model;

/**
 * Created by Ganga on 8/24/2016.
 */
public class EmailTpsModel {
    private String emailTpsId, emailAddress, active;

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
