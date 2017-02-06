package igc.tech.com.dao;

import java.util.List;

public interface RoomImportanceDao {

    public List procRoomImportance(String roomImportanceId, String rulesId, String roomTypeId, String active,
                                 String user, String flag);

}
