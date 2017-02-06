package igc.tech.com.dao;

import java.util.List;


public interface PopularPlaceDao {

	public List procPopularPlace(String popularPlaceId, String place, String type, String user, String flag);
	
}
