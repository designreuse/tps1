package igc.tech.com.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Ganga on 7/19/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailServerSettingModel {
    private String mailServerSettingId, displayName, emailId, password, host, port, active;

    public MailServerSettingModel() {
    }

    public MailServerSettingModel(String mailServerSettingId, String displayName, String emailId, String password, String host, String port, String active) {
        this.mailServerSettingId = mailServerSettingId;
        this.displayName = displayName;
        this.emailId = emailId;
        this.password = password;
        this.host = host;
        this.port = port;
        this.active = active;
    }

    public String getMailServerSettingId() {
        return mailServerSettingId;
    }

    public void setMailServerSettingId(String mailServerSettingId) {
        this.mailServerSettingId = mailServerSettingId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
