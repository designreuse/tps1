package igc.tech.com.dao;

import java.util.List;

public interface RoomFacilityAccessDao {

	public List procRoomFacilityAccess(String roomFacilityAccessId, String roomTypeId, String roomFacilityId, String user,
									   String flag) ;

}
