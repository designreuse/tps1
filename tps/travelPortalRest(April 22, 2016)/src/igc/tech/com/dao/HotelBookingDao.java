package igc.tech.com.dao;

import java.util.List;

public interface HotelBookingDao {

	public List procHotelBooking(String hotelBookingId, String roomTypeId, String adult, String child, String checkInDate,
								 String checkOutDate, String countryId, String company, String city,
								 String postalCode, String licenseNo, String airportPickUp,String customerDetailId,
								 String amount, String discountAmount, String totalAmount, String referenceNo, String payCategory,
								 String user, String flag) ;
}
