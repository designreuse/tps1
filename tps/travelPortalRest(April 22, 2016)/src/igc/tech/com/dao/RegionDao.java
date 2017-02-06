package igc.tech.com.dao;

import java.util.List;

public interface RegionDao {

	public List procRegion(String region_id, String region_name,
			String country_id, String user, String flag);

}
