package igc.tech.com.dao;

import igc.tech.com.model.RoomRateModel;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/16/2016.
 */
public interface RoomRateDao {

    public List procRoomRate(RoomRateModel roomRateModel,
                             String user,
                             String flag);

}
