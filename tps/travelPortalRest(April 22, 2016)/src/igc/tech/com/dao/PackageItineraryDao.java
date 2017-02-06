package igc.tech.com.dao;

import java.util.List;

public interface PackageItineraryDao {


	@SuppressWarnings("rawtypes")
	public List procPackageItinerary(String packageItineraryId, String packageInfoId,String day,String dayDetails,
			String hotelDetailId,String user,  String flag);

}
