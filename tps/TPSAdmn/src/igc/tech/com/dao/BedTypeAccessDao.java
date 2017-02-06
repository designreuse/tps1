package igc.tech.com.dao;

import java.util.List;

public interface BedTypeAccessDao {

	public List procBedTypeAccess(String bedTypeAccessId, String roomTypeId, String bedTypeId, String user,
								  String flag);

}
