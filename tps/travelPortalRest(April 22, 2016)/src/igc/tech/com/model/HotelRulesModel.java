package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tilak on 4/1/2016.
 */

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HotelRulesModel {

    private  String hotelRulesId;
    private  String hotelDetailid;
    private  String hotelName;
    private  String rulesId;
    private  String rulesDesc;

    public String getHotelRulesId() {
        return hotelRulesId;
    }

    public void setHotelRulesId(String hotelRulesId) {
        this.hotelRulesId = hotelRulesId;
    }

    public String getHotelDetailid() {
        return hotelDetailid;
    }

    public void setHotelDetailid(String hotelDetailid) {
        this.hotelDetailid = hotelDetailid;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRulesId() {
        return rulesId;
    }

    public void setRulesId(String rulesId) {
        this.rulesId = rulesId;
    }

    public String getRulesDesc() {
        return rulesDesc;
    }

    public void setRulesDesc(String rulesDesc) {
        this.rulesDesc = rulesDesc;
    }
}
