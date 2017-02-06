package igc.tech.com.model;

/**
 * Created by Ganga on 3/29/2016.
 */
public class FacilityModel {
    private String facilityId;
    private String facilityDesc;
    private String type, image, icon;

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityDesc() {
        return facilityDesc;
    }

    public void setFacilityDesc(String facilityDesc) {
        this.facilityDesc = facilityDesc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "FacilityModel{" +
                "facilityId='" + facilityId + '\'' +
                ", facilityDesc='" + facilityDesc + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
