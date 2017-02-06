package igc.tech.com.dao;

import java.util.List;
import java.util.Map;

public interface HotelFilterDao {

	public Map<String, Object> procHotelFilter(String searchValue, String checkInDate, String checkOutDate,
											   String noOfRooms, String noOfAdult,
											   String noOfChild, String childAges, String activites, String amenities,
											   String fromPrice, String toPrice, String type, String sortingType,String starRange, String pageNo, String offSet,String platform);
}
