package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PackageBookingStatusModel {


    private String packageBookingStatusId;
    private String packageBookingId;
    private String packageStatus;
    private String active;
    private String hashCode;

    private String user;


    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getPackageBookingStatusId() {
        return packageBookingStatusId;
    }

    public void setPackageBookingStatusId(String packageBookingStatusId) {
        this.packageBookingStatusId = packageBookingStatusId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }

    public String getPackageBookingId() {
        return packageBookingId;
    }

    public void setPackageBookingId(String packageBookingId) {
        this.packageBookingId = packageBookingId;
    }
}
