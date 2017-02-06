package igc.tech.com.dao;

import java.util.List;

public interface PackageAvailableDao {
	
	public List procPackageAvailable(String packageAvailableId, String availableDateId, String rate,
			String user, String flag);

}
