package igc.tech.com.dao;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 3/14/2016.
 */
public interface RoomImageDao {

    public List procRoomImage(String roomImageId, String roomTypeId,
                              String fileName, String caption, String ImageUrl,
                              String fileType, String thumbnail, String active,
                              String user, String flag);

}
