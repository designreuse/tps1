package igc.tech.com.dao;

import java.util.List;


public interface NearestAreaDao {

	public List procNearestArea(String nearestAreaId, String hotelDetailId, String popularPlaceId, String distance, String active, String user, String flag);
	
}
