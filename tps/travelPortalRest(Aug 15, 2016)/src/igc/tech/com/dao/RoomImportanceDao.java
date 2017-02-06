package igc.tech.com.dao;

import igc.tech.com.model.RoomImportanceModel;

import java.util.List;

public interface RoomImportanceDao {

    public List procRoomImportance(RoomImportanceModel importanceModel,
                                   String user, String flag);

}
