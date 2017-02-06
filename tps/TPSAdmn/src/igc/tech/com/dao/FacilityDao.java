package igc.tech.com.dao;

import java.util.List;


public interface FacilityDao {

	public List procFacility(String facilityId, String facilityDesc, String type, String icon, String image, String user, String flag);
	
}
