package igc.tech.com.dao;

import java.util.List;

public interface HotelBookingStatusDao {

    public List procHotelBookingStatus(String hotelBookingStatusId, String hotelBookingId, String hotelStatus, String active,String hashCode,
                                       String user, String flag);

}
