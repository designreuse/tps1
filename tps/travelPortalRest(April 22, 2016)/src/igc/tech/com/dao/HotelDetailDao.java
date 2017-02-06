package igc.tech.com.dao;

import java.util.List;

public interface HotelDetailDao {


	public List procHotelDetail(String hotelDetailId, String hotelName,
								String hotelPhNo1, String hotelPhNo2, String hotelPhNo3,
								String hotelAddress, String hotelEmailId, String areaId,
								String url,String clientDetailId,String user, String flag);

}
