package igc.tech.com.dao;

import igc.tech.com.model.RoomTypeModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface RoomTypeDao {

    public List procRoomType(RoomTypeModel tokenModel,
                             String user,
                             String flag);

}
