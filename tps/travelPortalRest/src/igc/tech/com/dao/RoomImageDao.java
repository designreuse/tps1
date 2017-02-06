package igc.tech.com.dao;

import igc.tech.com.model.RoomImageModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/14/2016.
 */
public interface RoomImageDao {

    public List procRoomImage(RoomImageModel roomImageModel,
                              String user, String flag);

}
