package igc.tech.com.model;

/**
 * Created by Ganga on 4/14/2016.
 */
public class HotelFeatureModel {

    private String hotelFeatureId, checkInFrom, checkInTo, checkOutFrom, checkOutTo,
            hotelDetailId, active;

    public String getHotelFeatureId() {
        return hotelFeatureId;
    }

    public void setHotelFeatureId(String hotelFeatureId) {
        this.hotelFeatureId = hotelFeatureId;
    }

    public String getCheckInFrom() {
        return checkInFrom;
    }

    public void setCheckInFrom(String checkInFrom) {
        this.checkInFrom = checkInFrom;
    }

    public String getCheckInTo() {
        return checkInTo;
    }

    public void setCheckInTo(String checkInTo) {
        this.checkInTo = checkInTo;
    }

    public String getCheckOutFrom() {
        return checkOutFrom;
    }

    public void setCheckOutFrom(String checkOutFrom) {
        this.checkOutFrom = checkOutFrom;
    }

    public String getCheckOutTo() {
        return checkOutTo;
    }

    public void setCheckOutTo(String checkOutTo) {
        this.checkOutTo = checkOutTo;
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

    @Override
    public String toString() {
        return "HotelFeatureModel{" +
                "hotelFeatureId='" + hotelFeatureId + '\'' +
                ", checkInFrom='" + checkInFrom + '\'' +
                ", checkInTo='" + checkInTo + '\'' +
                ", checkOutFrom='" + checkOutFrom + '\'' +
                ", checkOutTo='" + checkOutTo + '\'' +
                ", hotelDetailId='" + hotelDetailId + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
