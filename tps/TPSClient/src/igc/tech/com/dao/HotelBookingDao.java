package igc.tech.com.dao;

import igc.tech.com.model.HotelBookingModel;

import java.util.List;

public interface HotelBookingDao {

	public List procHotelBooking(HotelBookingModel hotelBookingModel,
								 String user, String flag) ;


}
