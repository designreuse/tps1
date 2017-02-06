package igc.tech.com.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.List;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class PackageInfoModel {

    private String packageInfoId;
    private String description;
    private String packageName;
    private String noOfDays;
    private String noOfNights;
    private String totalDays;
    private String packageDetails;
    private  String clientDetailId;
    private  String clientName;

    private String user;

    private List<PackageItineraryModel> packageItineraries;
    private List<AvailableDateRateModel> availableDateRates;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientDetailId() {
        return clientDetailId;
    }

    public void setClientDetailId(String clientDetailId) {
        this.clientDetailId = clientDetailId;
    }

    public List<PackageItineraryModel> getPackageItineraries() {
        return packageItineraries;
    }

    public void setPackageItineraries(List<PackageItineraryModel> packageItineraries) {
        this.packageItineraries = packageItineraries;
    }

    public List<AvailableDateRateModel> getAvailableDateRates() {
        return availableDateRates;
    }

    public void setAvailableDateRates(List<AvailableDateRateModel> availableDateRates) {
        this.availableDateRates = availableDateRates;
    }

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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "PackageInfoModel{" +
                "packageInfoId='" + packageInfoId + '\'' +
                ", description='" + description + '\'' +
                ", packageName='" + packageName + '\'' +
                ", noOfDays='" + noOfDays + '\'' +
                ", noOfNights='" + noOfNights + '\'' +
                ", totalDays='" + totalDays + '\'' +
                ", packageDetails='" + packageDetails + '\'' +
                ", clientDetailId='" + clientDetailId + '\'' +
                ", user='" + user + '\'' +
                ", packageItineraries=" + packageItineraries +
                ", availableDateRates=" + availableDateRates +
                '}';
    }
}
