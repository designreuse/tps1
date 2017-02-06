package igc.tech.com.dao;

import java.util.List;

public interface RoomFacilityDao {

    public List procRoomFacility(String roomFacilityId, String roomTypeId, String facilityId, String active,
                                 String user, String flag);

}
