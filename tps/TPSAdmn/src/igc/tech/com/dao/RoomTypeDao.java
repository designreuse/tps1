package igc.tech.com.dao;

import java.util.List;

public interface RoomTypeDao {

	public List procRoomType(String roomTypeId, String hotelDetailId, String roomCatetoryId, String bedTypeId, String roomDesc, String initialRate,
							 String maxAdult, String maxChild, String extraBedCharge, String push, String user, String flag);

}
