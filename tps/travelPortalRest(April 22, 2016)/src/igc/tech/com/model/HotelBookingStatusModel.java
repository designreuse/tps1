package igc.tech.com.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class HotelBookingStatusModel {


    private String hotelBookingStatusId;
    private String hotelBookingId;
    private String hotelStatus;
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


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHotelBookingStatusId() {
        return hotelBookingStatusId;
    }

    public void setHotelBookingStatusId(String hotelBookingStatusId) {
        this.hotelBookingStatusId = hotelBookingStatusId;
    }

    public String getHotelBookingId() {
        return hotelBookingId;
    }

    public void setHotelBookingId(String hotelBookingId) {
        this.hotelBookingId = hotelBookingId;
    }

    public String getHotelStatus() {
        return hotelStatus;
    }

    public void setHotelStatus(String hotelStatus) {
        this.hotelStatus = hotelStatus;
    }
}
