package igc.tech.com.dao;

import java.util.List;

public interface BedTypeDao {

	@SuppressWarnings("rawtypes")
	public List procBedType(String bedTypeId,String description,
			String hotelDetailId,  String user, String flag);

}
