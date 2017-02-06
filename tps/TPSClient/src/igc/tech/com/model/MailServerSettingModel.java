package igc.tech.com.model;

/**
 * Created by Ganga on 7/19/2016.
 */
public class MailServerSettingModel {
    private String mailServerSettingId, displayName, emailId, password, host, port, active;

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
