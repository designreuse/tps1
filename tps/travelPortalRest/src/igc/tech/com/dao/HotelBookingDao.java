package igc.tech.com.dao;

import igc.tech.com.model.ActivityModel;
import igc.tech.com.model.HotelBookingModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface HotelBookingDao {

    public List procHotelBooking(HotelBookingModel hotelBookingModel, String user, String flag);

}
