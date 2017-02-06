package igc.tech.com.dao;

import java.util.List;

public interface PackageLocationDao {

	@SuppressWarnings("rawtypes")
	public List procPackageLocation(String packageLocationId, String packageItineraryId,String areaId,
									String user,  String flag);

}
