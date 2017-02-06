package igc.tech.com.dao;

import igc.tech.com.model.NearPlacesModel;

import java.util.List;


public interface NearPlacesDao {

	public List procNearPlaces(NearPlacesModel nearPlacesModel, String user, String flag);
	
}
