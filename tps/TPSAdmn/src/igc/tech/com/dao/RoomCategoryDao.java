package igc.tech.com.dao;

import java.util.List;


public interface RoomCategoryDao {

	public List procRoomCategory(String roomCategoryId, String roomCategoryDesc, String user, String flag);
	
}
