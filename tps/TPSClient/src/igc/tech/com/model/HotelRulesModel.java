package igc.tech.com.model;

/**
 * Created by Ganga on 4/1/2016.
 */
public class HotelRulesModel {

    private String hotelRulesId, rulesId, hotelDetailId, active;

    private String rulesDesc, hotelName;

    public String getHotelRulesId() {
        return hotelRulesId;
    }

    public void setHotelRulesId(String hotelRulesId) {
        this.hotelRulesId = hotelRulesId;
    }

    public String getRulesId() {
        return rulesId;
    }

    public void setRulesId(String rulesId) {
        this.rulesId = rulesId;
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

    public String getRulesDesc() {
        return rulesDesc;
    }

    public void setRulesDesc(String rulesDesc) {
        this.rulesDesc = rulesDesc;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return "HotelRulesModel{" +
                "hotelRulesId='" + hotelRulesId + '\'' +
                ", rulesId='" + rulesId + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", rulesDesc='" + rulesDesc + '\'' +
                ", hotelName='" + hotelName + '\'' +
                '}';
    }
}
