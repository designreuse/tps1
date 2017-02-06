package igc.tech.com.dao;

import igc.tech.com.model.RoomDetailModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface RoomDetailDao {

    public List procRoomDetail(RoomDetailModel tokenModel,
                               String user,
                               String flag);

}
