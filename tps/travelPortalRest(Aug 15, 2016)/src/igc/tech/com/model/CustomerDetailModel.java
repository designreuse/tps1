package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CustomerDetailModel extends ResponseModel {

    private String customerDetailId;
    private String email;
    private String password;
    private String customerTitle;
    private String name;
    private String contactNo;
    private String customerType;
    private String appVersion;
    private String deviceEmail;
    private String deviceId;
    private String regKey;
    private String platform;
    private String activationCode;
    private  String otpCode;
    private String active;


    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCustomerDetailId() {
        return customerDetailId;
    }

    public void setCustomerDetailId(String customerDetailId) {
        this.customerDetailId = customerDetailId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCustomerTitle() {
        return customerTitle;
    }

    public void setCustomerTitle(String customerTitle) {
        this.customerTitle = customerTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceEmail() {
        return deviceEmail;
    }

    public void setDeviceEmail(String deviceEmail) {
        this.deviceEmail = deviceEmail;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getRegKey() {
        return regKey;
    }

    public void setRegKey(String regKey) {
        this.regKey = regKey;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    @Override
    public String toString() {
        return "CustomerDetailModel{" +
                "customerDetailId='" + customerDetailId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", customerTitle='" + customerTitle + '\'' +
                ", name='" + name + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", customerType='" + customerType + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", deviceEmail='" + deviceEmail + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", regKey='" + regKey + '\'' +
                ", platform='" + platform + '\'' +
                ", activationCode='" + activationCode + '\'' +
                ", otpCode='" + otpCode + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
