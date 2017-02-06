package igc.tech.com.dao;

import java.util.List;

/**
 * Created by IGC TECHNOLOGY on 2/14/2016.
 */
public interface HotelImageDao {

    public List procHotelImage(String hotelImageId, String hotelDetailId,
                               String fileName, String caption, String ImageUrl,
                               String fileType, String thumbnail, String active,
                               String user, String flag);

}



