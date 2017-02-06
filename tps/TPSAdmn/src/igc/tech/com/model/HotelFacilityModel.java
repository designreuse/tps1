package igc.tech.com.model;


public class HotelFacilityModel {

    private String hotelFacilityId;
    private String facilityId;
    private String hotelDetailId;
    private String active;
    private String hotelName;
    private String facilityDesc;
    private String type;

    private String user;

    public String getHotelFacilityId() {
        return hotelFacilityId;
    }

    public void setHotelFacilityId(String hotelFacilityId) {
        this.hotelFacilityId = hotelFacilityId;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(String hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getFacilityDesc() {
        return facilityDesc;
    }

    public void setFacilityDesc(String facilityDesc) {
        this.facilityDesc = facilityDesc;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HotelFacilityModel{" +
                "hotelFacilityId='" + hotelFacilityId + '\'' +
                ", facilityId='" + facilityId + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", active='" + active + '\'' +
                ", hotelName='" + hotelName + '\'' +
                ", facilityDesc='" + facilityDesc + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
