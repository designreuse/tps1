package igc.tech.com.model;

/**
 * Created by IGC TECHNOLOGY on 2/9/2016.
 */
public class AreaModel {

    private String areaId,areaName,regionId,RegionName,countryName,countryId;

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

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return RegionName;
    }

    public void setRegionName(String regionName) {
        RegionName = regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "AreaModel{" +
                "areaId='" + areaId + '\'' +
                ", areaName='" + areaName + '\'' +
                ", regionId='" + regionId + '\'' +
                ", RegionName='" + RegionName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", countryId='" + countryId + '\'' +
                '}';
    }
}
