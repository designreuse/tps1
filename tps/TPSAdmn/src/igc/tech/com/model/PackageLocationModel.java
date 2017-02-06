package igc.tech.com.model;


public class PackageLocationModel {

    private String packageLocationId;
    private String packageName;
    private String packageItineraryId;
    private String day;
    private String regionId;
    private String regionName;
    private String countryName;
    private String areaId;
    private String areaName;

    private String user;


    public String getPackageLocationId() {
        return packageLocationId;
    }

    public void setPackageLocationId(String packageLocationId) {
        this.packageLocationId = packageLocationId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageItineraryId() {
        return packageItineraryId;
    }

    public void setPackageItineraryId(String packageItineraryId) {
        this.packageItineraryId = packageItineraryId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "PackageLocationModel{" +
                "packageLocationId='" + packageLocationId + '\'' +
                ", packageName='" + packageName + '\'' +
                ", packageItineraryId='" + packageItineraryId + '\'' +
                ", day='" + day + '\'' +
                ", regionId='" + regionId + '\'' +
                ", regionName='" + regionName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
