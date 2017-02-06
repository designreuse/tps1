package igc.tech.com.dao;

import igc.tech.com.model.NearestAreaModel;

import java.util.List;


public interface NearestAreaDao {

	public List procNearestArea(NearestAreaModel nearestAreaModel, String user, String flag);
	
}
