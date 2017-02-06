package igc.tech.com.model;


public class PackageInfoModel {


    public PackageInfoModel() {
    }

    private String packageInfoId;
    private String description;
    private String noOfDays;
    private String noOfNights;
    private String totalDays;
    private String packageDetails;
    private String user;
    private String clientDetailId;
    private String clientName;
    private String companyName;


    public String getPackageInfoId() {
        return packageInfoId;
    }

    public void setPackageInfoId(String packageInfoId) {
        this.packageInfoId = packageInfoId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(String noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getNoOfNights() {
        return noOfNights;
    }

    public void setNoOfNights(String noOfNights) {
        this.noOfNights = noOfNights;
    }

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }

    public String getPackageDetails() {
        return packageDetails;
    }

    public void setPackageDetails(String packageDetails) {
        this.packageDetails = packageDetails;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClientDetailId() {
        return clientDetailId;
    }

    public void setClientDetailId(String clientDetailId) {
        this.clientDetailId = clientDetailId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "PackageInfoModel{" +
                "packageInfoId='" + packageInfoId + '\'' +
                ", description='" + description + '\'' +
                ", noOfDays='" + noOfDays + '\'' +
                ", noOfNights='" + noOfNights + '\'' +
                ", totalDays='" + totalDays + '\'' +
                ", packageDetails='" + packageDetails + '\'' +
                ", user='" + user + '\'' +
                ", clientDetailId='" + clientDetailId + '\'' +
                ", clientName='" + clientName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
